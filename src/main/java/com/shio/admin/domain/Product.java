package com.shio.admin.domain;

import lombok.Data;
import javax.persistence.*;

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

}
