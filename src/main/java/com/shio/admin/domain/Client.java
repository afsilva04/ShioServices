package com.shio.admin.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

@Entity
@Table(name = "Client")
@Data
public class Client {

    @Id
    @GeneratedValue
    @NotNull(groups = Existing.class, message = "Se requiere el ID")
    @Null(groups = New.class, message = "El ID debe ser nulo")
    private Long id;
    @NotEmpty (message = "El NOMBRE es obligatorio")
    private String name;
    private String email;
    @NotEmpty (message = "El TELEFONO es obligatorio")
    private String phone;
    private String mobile;
    private String birthdate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    private String location;
    private String colony;
    private String address;
    private String zip;
    private String rfc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsidiaryId")
    private Subsidiary subsidiary;

    private String active;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Appointment> appointments;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Transaction> transactions;

    public interface Existing { }
    public interface New { }

}


