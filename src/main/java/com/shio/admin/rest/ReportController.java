package com.shio.admin.rest;

import com.shio.admin.DTO.*;
import com.shio.admin.security.SecurityUtils;
import com.shio.admin.service.ReportService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.shio.admin.security.SecurityUtils.SECRET;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/reports")
public class ReportController {

    private ReportService reportService;
    private HttpServletRequest httpServletRequest;

    @GetMapping("/sales")
    public List<SalesReportDTO> salesReport(){
//        String token = httpServletRequest.getHeader("Authorization");
//        String tokenClean = token.split(" ")[1];
//        String[] split_string = tokenClean.split("\\.");
//
//        Jwt<Header,Claims> parsedToken = Jwts.parser().parse(split_string[0] + "." + split_string[1] + ".");
//        Long sub = new Long(parsedToken.getBody().get("subsidiary").toString());

        return reportService.salesReport(SecurityUtils.getSubsidiaryFromToken(httpServletRequest));
    }

    @GetMapping("/appointments")
    public List<AppointmentsReportDTO> appointmentReport() {
        return reportService.appointmentsReport(SecurityUtils.getSubsidiaryFromToken(httpServletRequest));
    }

    @GetMapping("/appointments-in-progress")
    public List<AppointmentsInProgressReportDTO> appointmentsInProgress() {
        return reportService.appointmentsInProgressReport(SecurityUtils.getSubsidiaryFromToken(httpServletRequest));
    }

    @GetMapping("/close")
    public CloseReportResumeDTO closeReport() {
        return reportService.closeReport(SecurityUtils.getSubsidiaryFromToken(httpServletRequest));
    }

    @GetMapping("/day")
    public DayReportResumeDTO dayReport() {
        return reportService.dayReport(SecurityUtils.getSubsidiaryFromToken(httpServletRequest));
    }

}
