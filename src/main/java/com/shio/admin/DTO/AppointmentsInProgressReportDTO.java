package com.shio.admin.DTO;

import com.shio.admin.domain.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class AppointmentsInProgressReportDTO {

    private Long appointmentId;
    private Long appointmentItemId;
    private StatusEnum status;
    private OffsetDateTime started;
    private int minutesLeft;
    private String serviceName;
    private String clientName;
    private String employeeName;
    private String subsidiaryName;

}
