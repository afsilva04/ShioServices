package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class CloseReportDTO {

    private String reason;
    private OffsetDateTime date;
    private Long productId;
    private String productName;
    private Long serviceId;
    private String serviceName;
    private String concept;
    private int quantity;
    private BigDecimal price;
    private BigDecimal total;
    private int commision;
    private BigDecimal commisionTotal;
    private Long employeeId;
    private String employeeName;
    private Long clientId;
    private String clientName;
    private Long subsidiaryId;
    private String subsidiaryName;

}
