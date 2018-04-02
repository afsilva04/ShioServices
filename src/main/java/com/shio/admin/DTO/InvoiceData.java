package com.shio.admin.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InvoiceData {

    private Long transactionId;
    private String paymentMethod;
    private String rfc;
    private String rfcName;

}
