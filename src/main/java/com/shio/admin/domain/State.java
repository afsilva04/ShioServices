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
@Table(name = "State")
@Data
public class State {

    @Id
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "state")
    private Set<Client> clients;
}
