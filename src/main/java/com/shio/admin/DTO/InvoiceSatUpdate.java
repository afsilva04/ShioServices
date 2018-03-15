package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceSatUpdate {

    private Long transaction;
    private String invoice;
    private String pdf;

}
