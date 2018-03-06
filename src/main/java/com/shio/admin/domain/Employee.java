package com.shio.admin.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@Data
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String position;
    private String active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsidiaryId")
    private Subsidiary subsidiary;

}
