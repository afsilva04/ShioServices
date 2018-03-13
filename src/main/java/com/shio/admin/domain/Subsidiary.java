package com.shio.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

/**
 * @author afsilva
 */
@Entity
@Table(name = "Subsidiary")
@Data
public class Subsidiary {

    @Id
    private long id;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String location;
    private String colony;
    private String address;
    private String zip;
    private String active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    @JsonIgnore
    @OneToMany(mappedBy = "subsidiary")
    private Set<Client> clients;

    @JsonIgnore
    @OneToMany(mappedBy = "subsidiary")
    private Set<Employee> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "subsidiary")
    private Set<Appointment> appointments;

    @JsonIgnore
    @OneToMany(mappedBy = "subsidiary")
    private Set<Transaction> transactions;

}