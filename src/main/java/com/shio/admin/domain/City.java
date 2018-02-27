package com.shio.admin.domain;

import lombok.Data;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

/**
 * @author afsilva
 */
@Entity
@Table(name = "City")
@Data
public class City {

    //@Column(name = "city_id")
    @Id
    private long id;
    private String name;
    private String state;

    //@JsonIgnore
    @OneToMany(mappedBy = "city")
    private Set<Client> clients;
}
