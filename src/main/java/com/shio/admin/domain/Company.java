package com.shio.admin.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Company")
@Data
public class Company {

    @Id
    private long id;
    private String name;
    private String rfc;
    private String certificate;
    private String location;
    private String colony;
    private String address;
    private String zip;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

}
