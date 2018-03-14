package com.shio.admin.DTO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Receptor {

    private String Rfc;
    private String Nombre;
    private String NumRegIdTrib;
    private String UsoCFDI;
    private String Calle;
    private String NoExt;
    private String NoInt;
    private String Colonia;
    private String Localidad;
    private String Referencia;
    private String Municipio;
    private String Estado;
    private String Pais;
    private String CodigoPostal;

}
