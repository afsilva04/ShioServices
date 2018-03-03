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
@Table(name = "Country")
@Data
public class Country {

    //@Column(name = "country_id")
    @Id
    private long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private Set<Client> states;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private Set<Client> clients;

}