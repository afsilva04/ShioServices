package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author afsilva
 */
@Getter
@Setter
public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String birthdate;
    private Long countryId;
    private String countryName;
    private Long stateId;
    private String stateName;
    private Long cityId;
    private String cityName;
    private String location;
    private String colony;
    private String address;
    private String zip;
    private String rfc;
    private Long subsidiaryId;
    private String subsidiaryName;
    private String active;
    private String searchText;

}