package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CloseReportResumeDTO {

    private BigDecimal commission;
    private BigDecimal total;
    private List<CloseReportDTO> items;

}
