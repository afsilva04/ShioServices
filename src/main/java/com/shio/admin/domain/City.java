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
@Table(name = "City")
@Data
public class City {

    //@Column(name = "city_id")
    @Id
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private Set<Client> clients;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private Set<Subsidiary> subsidiaries;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private Set<Company> companies;
}
