package com.shio.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String position;
    private String active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsidiaryId")
    private Subsidiary subsidiary;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Set<AppointmentItem> appointmentItems;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Set<TransactionItem> transactionItems;

}
