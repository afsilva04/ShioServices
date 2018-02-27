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
@Table(name = "Subsidiary")
@Data
public class Subsidiary {

    @Id
    private long id;
    private String name;
    /*private String email;
    private String phone;
    private String mobile;
    private String company;
    private String country;*/

    @OneToMany(mappedBy = "subsidiary")
    private Set<Client> clients;
}