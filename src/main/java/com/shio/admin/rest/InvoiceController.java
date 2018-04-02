package com.shio.admin.rest;

import com.shio.admin.DTO.CfdiRequest;
import com.shio.admin.DTO.InvoiceDTO;
import com.shio.admin.DTO.InvoiceData;
import com.shio.admin.DTO.InvoiceSatUpdate;
import com.shio.admin.domain.Transaction;
import com.shio.admin.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private InvoiceService invoiceService;

    @GetMapping("{idTransaction}")
    public InvoiceDTO getInvoiceInfo(@PathVariable("idTransaction") Long idTransaction){
        return invoiceService.getInvoiceData(idTransaction);
    }

    @GetMapping("request/{id}")
    public CfdiRequest getRequest(@PathVariable("id") Long id){
        return invoiceService.getCfdiRequest(new InvoiceData(id, null, null, null));
    }

    @PostMapping
    public String satInvoice(@RequestBody InvoiceData invoiceData){
        return invoiceService.createInvoice(invoiceData);
    }

    @PutMapping
    public Transaction updateInvoiceToTransaction(@RequestBody InvoiceSatUpdate invoiceSatUpdate){
        return invoiceService.updateInvoiceToTransaction(invoiceSatUpdate);
    }

}
