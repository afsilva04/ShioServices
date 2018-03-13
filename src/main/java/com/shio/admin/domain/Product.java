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
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String codbar;
    private String commission;
    private String active;
    private String price;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<TransactionItem> transactionItems;

}