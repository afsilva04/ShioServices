package com.shio.admin.DTO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class CfdiRequest {

    private String Serie;
    private int Folio;
    private String Fecha;
    private String FormaPago;
    private String CondicionesDePago;
    private String SubTotal;
    private String Descuento;
    private String Moneda;
    private int TipoCambio;
    private String Total;
    private String TipoDeComprobante;
    private String MetodoPago;
    private String LugarExpedicion;
    private String LeyendaFolio;

    private Emisor Emisor;
    private Receptor Receptor;
    private List<Concepto> Conceptos;
    private Impuesto Impuestos;

}