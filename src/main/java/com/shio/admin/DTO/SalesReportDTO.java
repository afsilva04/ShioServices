package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalesReportDTO {

    private String date;
    private Long productId;
    private String productName;
    private Long serviceId;
    private String serviceName;
    private int quantity;
    private BigDecimal price;
    private BigDecimal total;
    private int commision;
    private Long employeeId;
    private String employeeName;
    private Long clientId;
    private String clientName;
    private Long subsidiaryId;
    private String subsidiaryName;

}