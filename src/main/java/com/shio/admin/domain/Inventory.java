package com.shio.admin.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
@Data
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsidiary_id")
    private Subsidiary subsidiary;

}