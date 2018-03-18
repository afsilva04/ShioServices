package com.shio.admin.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Transactioncoupon")
@Data
public class TransactionCoupon {

    @Id
    @GeneratedValue
    private Long id;
    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

}
