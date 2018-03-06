package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class AppointmentItemDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String time;
    private String status;
    private Long serviceId;
    private Long appointmentId;

}
