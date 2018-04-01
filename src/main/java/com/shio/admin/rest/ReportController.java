package com.shio.admin.rest;

import com.shio.admin.DTO.AppointmentsReportDTO;
import com.shio.admin.DTO.SalesReportDTO;
import com.shio.admin.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/reports")
public class ReportController {

    private ReportService reportService;

    @GetMapping("/sales")
    public List<SalesReportDTO> salesReport(){
        return reportService.salesReport();
    }

    @GetMapping("/appointments")
    public List<AppointmentsReportDTO> appointmentReport() { return reportService.appointmentsReport(); }

    @GetMapping("/close")
    public List<SalesReportDTO> closeReport() { return reportService.closeReport(); }

    @GetMapping("/day")
    public List<SalesReportDTO> dayReport() { return reportService.dayReport(); }

}
