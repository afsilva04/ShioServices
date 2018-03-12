package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class AppointmentViewDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String note;
    private String rescheduled;
    private Long clientId;
    private String clientName;
    private Long subsidiaryId;
    private String subsidiaryName;

}
