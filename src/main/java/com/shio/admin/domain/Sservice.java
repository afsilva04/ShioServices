package com.shio.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

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
    private BigDecimal price;
    private String time;
    private String key;
    private String unit;

    @JsonIgnore
    @OneToMany(mappedBy = "service")
    private Set<AppointmentItem> appointmentItems;

    @JsonIgnore
    @OneToMany(mappedBy = "service")
    private Set<TransactionItem> transactionItems;

}
