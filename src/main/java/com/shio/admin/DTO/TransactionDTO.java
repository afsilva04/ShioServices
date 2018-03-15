package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
public class TransactionDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String invoice;
    private String invoicePdf;
    private Boolean canceled;
    private Boolean processed;
    private String reasonId;
    private Long clientId;
    private String clientName;
    private Long subsidiaryId;
    private String subsidiaryName;

}
