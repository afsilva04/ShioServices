package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class CompanyDTO {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String rfc;
    private String certificate;
    private String location;
    private String colony;
    private String address;
    private String zip;
    private Long countryId;
    private String countryName;
    private Long stateId;
    private String stateName;
    private Long cityId;
    private String cityName;

}
