package com.shio.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String invoice;
    private String invoicepdf;
    private Boolean canceled;
    private Boolean processed;
    private String reason;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsidiary_id")
    private Subsidiary subsidiary;

    @JsonIgnore
    @OneToMany(mappedBy = "transaction")
    private Set<TransactionItem> transactionItems;

    @JsonIgnore
    @OneToMany(mappedBy = "transaction")
    private Set<TransactionCoupon> transactionCoupons;

}
