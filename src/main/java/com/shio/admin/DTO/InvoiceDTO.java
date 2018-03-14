package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class InvoiceDTO {

    private TransactionDTO transaction;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal total;
    private List<TransactionItemDTO> transactionItems;

}
