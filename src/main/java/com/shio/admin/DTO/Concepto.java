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
public class Concepto {

    private String ClaveProdServ;
    private String NoIdentificacion;
    private int Cantidad;
    private String ClaveUnidad;
    private String Unidad;
    private String Descripcion;
    private String ValorUnitario;
    private String Importe;
    private ImpuestoConcepto Impuestos;

}
