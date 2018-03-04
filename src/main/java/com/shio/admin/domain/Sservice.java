package com.shio.admin.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "service")
@Data
public class Sservice {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String codbar;
    private String commission;
    private String active;
    private String price;
    private String time;

}
