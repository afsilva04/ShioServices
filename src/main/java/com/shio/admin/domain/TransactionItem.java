package com.shio.admin.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Entity
@Table(name = "Transactionitem")
@Data
public class TransactionItem {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private int quantity;
    private BigDecimal price;
    private BigDecimal aditional;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
    private Sservice service;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

}
