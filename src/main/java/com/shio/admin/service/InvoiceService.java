package com.shio.admin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shio.admin.DTO.*;
import com.shio.admin.domain.Transaction;
import com.shio.admin.mappers.TransactionItemMapper;
import com.shio.admin.mappers.TransactionMapper;
import com.shio.admin.persistence.ClientRepository;
import com.shio.admin.persistence.TransactionItemRepository;
import com.shio.admin.persistence.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InvoiceService {

    private TransactionRepository transactionRepository;
    private TransactionItemRepository transactionItemRepository;
    private ClientRepository clientRepository;
    private TransactionMapper transactionMapper;
    private TransactionItemMapper transactionItemMapper;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public InvoiceDTO getInvoiceData(Long id){

        InvoiceDTO invoiceDTO = new InvoiceDTO();

        invoiceDTO.setTransaction(transactionMapper.toDTO(transactionRepository.findById(id).get()));

        invoiceDTO.setTransactionItems(transactionItemRepository.findAllByTransactionId(id)
                .stream()
                .map(i -> transactionItemMapper.toDTO(i))
                .collect(Collectors.toList()));

        invoiceDTO.setSubtotal(invoiceDTO.getTransactionItems()
                .stream()
                .map(s -> s.getPrice().multiply((new BigDecimal(s.getQuantity()))).add(s.getAditional()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_UP));

        invoiceDTO.setTax(invoiceDTO.getSubtotal()
                .multiply(new BigDecimal(0.16).setScale(2, BigDecimal.ROUND_HALF_EVEN))
                .setScale(2, BigDecimal.ROUND_UP));

        invoiceDTO.setTotal(invoiceDTO.getSubtotal()
                .add(invoiceDTO.getTax())
                .setScale(2, BigDecimal.ROUND_UP));

        return invoiceDTO;
    }

    public String createInvoice(InvoiceData invoiceData)
    {
        CfdiRequest cfdiRequest = getCfdiRequest(invoiceData);

        try {
            String bodyValue = StringUtils.uncapitalize(objectMapper.writeValueAsString(cfdiRequest));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cookie", "xnovatech_session=9m45hicpg907u1v6aqbnfjibrpt6dmq4");
            headers.add("api-usuario", "demo33");
            headers.add("api-password", "demo");
            headers.add("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            headers.add("Accept", "application/jsonp");

            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("jsoncfdi", bodyValue);

            HttpEntity<MultiValueMap<String, String>> request =
                    new HttpEntity<MultiValueMap<String, String>>(map, headers);

            String response = restTemplate.postForObject(
                    "https://app.facturadigital.com.mx/api/cfdi/generar",
                    request,
                    String.class
            );

            return response;

        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public CfdiRequest getCfdiRequest(InvoiceData invoiceData){

        InvoiceDTO invoiceDTO = getInvoiceData(invoiceData.getTransactionId());
        Transaction transaction = transactionRepository.findById(invoiceData.getTransactionId()).get();

        CfdiRequest cfdiRequest = new CfdiRequest();
        //cfdiRequest.setSerie("F");
        //cfdiRequest.setFolio(24200);
        cfdiRequest.setFecha("AUTO");
        cfdiRequest.setFormaPago(invoiceData.getPaymentMethod());
        //cfdiRequest.setCondicionesDePago("CONDICIONES");
        cfdiRequest.setSubTotal(invoiceDTO.getSubtotal().toString());
        //cfdiRequest.setDescuento(null);
        cfdiRequest.setMoneda("MXN");
        //cfdiRequest.setTipoCambio(1);
        cfdiRequest.setTotal(invoiceDTO.getTotal().toString());
        cfdiRequest.setTipoDeComprobante("I");
        cfdiRequest.setMetodoPago("PUE");
        cfdiRequest.setLugarExpedicion("67150"); //Cambiar por codigo postal de la sucursal
        cfdiRequest.setLeyendaFolio("FACTURA"); //Opcional

        Emisor emisor = new Emisor();
        emisor.setRegimenFiscal("612"); //Cambiar al de Shio 601
        cfdiRequest.setEmisor(emisor);

        Receptor receptor = new Receptor();
        receptor.setRfc(transaction.getClient().getRfc());
        receptor.setNombre(transaction.getClient().getName());
        //receptor.setNumRegIdTrib("");
        receptor.setUsoCFDI("G01");
        receptor.setCalle(transaction.getClient().getAddress());
        //receptor.setNoExt("25");
        //receptor.setNoInt(null);
        receptor.setColonia(transaction.getClient().getColony());
        receptor.setLocalidad(transaction.getClient().getLocation());
        //receptor.setReferencia(null);
        receptor.setMunicipio(transaction.getClient().getCity().getName());
        receptor.setEstado(transaction.getClient().getCity().getState().getName());
        receptor.setPais(transaction.getClient().getCity().getState().getCountry().getName());
        receptor.setCodigoPostal(transaction.getClient().getZip());
        cfdiRequest.setReceptor(receptor);

        BigDecimal itemTotal;
        BigDecimal tax = new BigDecimal(0.16).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        ArrayList<Concepto> conceptos = new ArrayList<>();
        for (TransactionItemDTO item: invoiceDTO.getTransactionItems()){
            itemTotal = BigDecimal.ZERO;

            Concepto concepto = new Concepto();
            concepto.setClaveProdServ("78102206");
            concepto.setNoIdentificacion("120315");
            concepto.setCantidad(item.getQuantity());
            concepto.setClaveUnidad("XUN"); //Unidad
            //concepto.setUnidad("");
            if (item.getProductId() != null)
                concepto.setDescripcion(item.getProductName());
            else
                concepto.setDescripcion(item.getServiceName());
            concepto.setValorUnitario(item.getPrice().toString());
            itemTotal = item.getPrice().multiply(new BigDecimal(item.getQuantity()));
            concepto.setImporte(itemTotal.toString());

            ImpuestoConcepto impuestoConcepto = new ImpuestoConcepto();
            Traslado traslado = new Traslado();
            traslado.setBase(itemTotal.toString());
            traslado.setImpuesto("002");
            traslado.setTipoFactor("Tasa");
            traslado.setTasaOCuota(tax.toString());
            traslado.setImporte(itemTotal.multiply(tax).toString());
            ArrayList<Traslado> traslados = new ArrayList<>();
            traslados.add(traslado);
            impuestoConcepto.setTraslados(traslados);
            concepto.setImpuestos(impuestoConcepto);
            conceptos.add(concepto);
        }

        cfdiRequest.setConceptos(conceptos);

        Impuesto impuesto = new Impuesto();
        impuesto.setTotalImpuestosTrasladados(invoiceDTO.getTax().toString());
        TrasladoImp trasladoImp = new TrasladoImp();
        trasladoImp.setImpuesto("002"); //IVA
        trasladoImp.setTipoFactor("Tasa");
        trasladoImp.setTasaOCuota(tax.toString());
        trasladoImp.setImporte(invoiceDTO.getTax().toString());
        ArrayList<TrasladoImp> trasladoImps = new ArrayList();
        trasladoImps.add(trasladoImp);
        impuesto.setTraslados(trasladoImps);
        cfdiRequest.setImpuestos(impuesto);

        return cfdiRequest;
    }

    public Transaction updateInvoiceToTransaction(InvoiceSatUpdate invoiceSatUpdate){
        TransactionDTO transactionDTO = transactionMapper.toDTO
                (transactionRepository.findById(invoiceSatUpdate.getTransaction()).get());
        if(invoiceSatUpdate.getInvoice().equals("0"))
            transactionDTO.setInvoice("");
        else
            transactionDTO.setInvoice(invoiceSatUpdate.getInvoice());
        transactionDTO.setInvoicePdf(invoiceSatUpdate.getPdf());
        return transactionRepository.save(transactionMapper.toEntity(transactionDTO));
    }

}
