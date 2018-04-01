package com.shio.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String codbar;
    private int commission;
    private String active;
    private String price;
    private String key;
    private String unit;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<TransactionItem> transactionItems;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<Inventory> inventories;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<EntryItem> entryItems;

}
