package com.shio.admin.rest.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class ProductDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String codbar;
    private String commission;
    private String active;
    private String price;

}
