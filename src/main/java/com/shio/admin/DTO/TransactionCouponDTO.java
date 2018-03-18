package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class TransactionCouponDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private Long transactionId;

}
