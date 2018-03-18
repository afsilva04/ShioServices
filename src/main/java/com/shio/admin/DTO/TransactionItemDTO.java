package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
public class TransactionItemDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private int quantity;
    private BigDecimal price;
    private BigDecimal aditional;
    private Boolean anticipated;
    private String coupon;
    private String dateused;
    private Long productId;
    private String productName;
    private Long serviceId;
    private String serviceName;
    private Long employeeId;
    private String employeeName;
    private Long transactionId;

}
