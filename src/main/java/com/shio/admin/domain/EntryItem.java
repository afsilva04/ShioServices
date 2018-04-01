package com.shio.admin.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Entryitem")
@Data
public class EntryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entry_id")
    private Entry entry;

}
