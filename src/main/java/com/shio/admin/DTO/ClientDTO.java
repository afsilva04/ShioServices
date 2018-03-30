package com.shio.admin.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author afsilva
 */
@Getter
@Setter
public class ClientDTO {

    @Id
    @GeneratedValue
    @NotNull(groups = Existing.class, message = "Se requiere el ID")
    @Null(groups = New.class, message = "El ID debe ser nulo")
    private Long id;
    @NotEmpty(message = "El NOMBRE es obligatorio")
    private String name;
    private String email;
    @NotEmpty (message = "El TELEFONO es obligatorio")
    private String phone;
    private String mobile;
    private String birthdate;
    private long countryId;
    private String countryTxt;
    private long stateId;
    private String stateTxt;
    private long cityId;
    private String cityTxt;
    private String location;
    private String colony;
    private String address;
    private String zip;
    private String rfc;
    private long subsidiaryId;
    private String subsidiaryTxt;
    private String active;
    private String searchText;

    public interface Existing { }
    public interface New { }

}


