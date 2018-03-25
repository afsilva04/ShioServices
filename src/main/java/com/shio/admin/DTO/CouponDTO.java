package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class CouponDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private int quantity;
    private int available;
    private Long transactionorigin;
    private Long transactionused;
    private Long productId;
    private String productName;
    private Long serviceId;
    private String serviceName;
    private Long clientId;
    private String clientName;

}
