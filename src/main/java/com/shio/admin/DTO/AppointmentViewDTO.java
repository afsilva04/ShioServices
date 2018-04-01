package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AppointmentViewDTO {

    @Id
    @GeneratedValue
    private Long id;
    private OffsetDateTime date;
    private String note;
    private Boolean rescheduled;
    private Long clientId;
    private String clientName;
    private Long subsidiaryId;
    private String subsidiaryName;

}
