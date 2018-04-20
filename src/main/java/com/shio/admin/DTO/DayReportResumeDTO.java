package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class DayReportResumeDTO {

    private int customersServed;
    private int rescheduledAppointments;
    private int nextDayAppointments;
    private BigDecimal avgTicket;
    private BigDecimal salesTotal;
    private List<DayReportDTO> items;

}
