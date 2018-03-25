package com.shio.admin.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Coupon")
@Data
public class Coupon {

    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private int quantity;
    private int available;
    private Long transactionorigin;
    private Long transactionused;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
    private Sservice service;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

}
