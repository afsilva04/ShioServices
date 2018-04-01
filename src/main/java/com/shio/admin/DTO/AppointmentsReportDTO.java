package com.shio.admin.DTO;

import com.shio.admin.domain.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class AppointmentsReportDTO {

    private OffsetDateTime time;
    private StatusEnum status;
    private String serviceName;
    private String clientName;
    private String employeeName;
    private String subsidiaryName;

}
