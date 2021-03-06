package com.shio.admin.DTO;

import com.shio.admin.domain.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AppointmentItemDTO {

    @Id
    @GeneratedValue
    private Long id;
    private OffsetDateTime time;
    private OffsetDateTime started;
    private StatusEnum status;
    private Long serviceId;
    private String serviceName;
    private Long employeeId;
    private String employeeName;
    private Long appointmentId;

}
