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
@Table(name = "State")
@Data
public class State {

    @Id
    private long id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "state")
    private Set<Client> clients;
}
