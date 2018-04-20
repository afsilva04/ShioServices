package com.shio.admin.service;

import com.shio.admin.DTO.*;
import com.shio.admin.domain.*;
import com.shio.admin.persistence.AppointmentItemRepository;
import com.shio.admin.persistence.AppointmentRepository;
import com.shio.admin.persistence.TransactionItemRepository;
import com.shio.admin.persistence.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ReportService {

    private AppointmentRepository appointmentRepository;
    private TransactionRepository transactionRepository;
    private TransactionItemRepository transactionItemRepository;
    private AppointmentItemRepository appointmentItemRepository;

    public List<SalesReportDTO> salesReport(){

        List<TransactionItem> transactionItems = transactionItemRepository.findAll();
        List<SalesReportDTO> salesReportDTOS = new ArrayList<>();

        for (TransactionItem item : transactionItems) {
            if(item.getTransaction().getReason() == "1"
                    && item.getTransaction().getInvoice() != null
                    && item.getTransaction().getInvoice() != "") {
                SalesReportDTO salesReportDTO = new SalesReportDTO();
                salesReportDTO.setDate(item.getTransaction().getDate());
                if (item.getProduct() != null) {
                    salesReportDTO.setProductId(item.getProduct().getId());
                    salesReportDTO.setProductName(item.getProduct().getName());
                    salesReportDTO.setCommision(item.getProduct().getCommission());
                }
                if (item.getService() != null) {
                    salesReportDTO.setServiceId(item.getService().getId());
                    salesReportDTO.setServiceName(item.getService().getName());
                    salesReportDTO.setCommision(item.getService().getCommission());
                }
                salesReportDTO.setQuantity(item.getQuantity());
                salesReportDTO.setPrice(item.getPrice());
                salesReportDTO.setTotal(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
                if (item.getTransaction().getClient() != null) {
                    salesReportDTO.setClientId(item.getTransaction().getClient().getId());
                    salesReportDTO.setClientName(item.getTransaction().getClient().getName());
                }
                if(item.getEmployee() != null){
                    salesReportDTO.setEmployeeId(item.getEmployee().getId());
                    salesReportDTO.setEmployeeName(item.getEmployee().getName());
                }
                if (item.getTransaction().getSubsidiary() != null) {
                    salesReportDTO.setSubsidiaryId(item.getTransaction().getSubsidiary().getId());
                    salesReportDTO.setSubsidiaryName(item.getTransaction().getSubsidiary().getName());
                }

                salesReportDTOS.add(salesReportDTO);
            }
        }

        return salesReportDTOS;
    }

    public CloseReportResumeDTO closeReport(){

        List<TransactionItem> transactionItems = transactionItemRepository.findAll();
        List<CloseReportDTO> closeReportDTOS = new ArrayList<>();

        BigDecimal commissionResume  = new BigDecimal(0);
        BigDecimal totalResume = new BigDecimal(0);

        for (TransactionItem item : transactionItems) {
            if(item.getTransaction().getReason() == "1" || item.getTransaction().getReason() == "2") {
                CloseReportDTO closeReportDTO = new CloseReportDTO();

                closeReportDTO.setReason(item.getTransaction().getReason());
                closeReportDTO.setDate(item.getTransaction().getDate());
                if (item.getProduct() != null) {
                    closeReportDTO.setProductId(item.getProduct().getId());
                    closeReportDTO.setProductName(item.getProduct().getName());
                    closeReportDTO.setCommision(item.getProduct().getCommission());
                    closeReportDTO.setConcept(closeReportDTO.getProductName());
                }
                if (item.getService() != null) {
                    closeReportDTO.setServiceId(item.getService().getId());
                    closeReportDTO.setServiceName(item.getService().getName());
                    closeReportDTO.setCommision(item.getService().getCommission());
                    closeReportDTO.setConcept(closeReportDTO.getServiceName());
                }
                closeReportDTO.setQuantity(item.getQuantity());
                closeReportDTO.setPrice(item.getPrice());
                closeReportDTO.setTotal(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
                totalResume = totalResume.add(closeReportDTO.getTotal());
                closeReportDTO.setCommisionTotal(closeReportDTO.getTotal()
                        .multiply(new BigDecimal(closeReportDTO.getCommision())
                                .divide(new BigDecimal(100), 2, BigDecimal.ROUND_UP)));
                commissionResume = commissionResume.add(closeReportDTO.getCommisionTotal());
                if (item.getTransaction().getClient() != null) {
                    closeReportDTO.setClientId(item.getTransaction().getClient().getId());
                    closeReportDTO.setClientName(item.getTransaction().getClient().getName());
                }
                if (item.getEmployee() != null) {
                    closeReportDTO.setEmployeeId(item.getEmployee().getId());
                    closeReportDTO.setEmployeeName(item.getEmployee().getName());
                }
                if (item.getTransaction().getSubsidiary() != null) {
                    closeReportDTO.setSubsidiaryId(item.getTransaction().getSubsidiary().getId());
                    closeReportDTO.setSubsidiaryName(item.getTransaction().getSubsidiary().getName());
                }

                closeReportDTOS.add(closeReportDTO);
            }
        }

        CloseReportResumeDTO closeReportResumeDTO = new CloseReportResumeDTO();
        closeReportResumeDTO.setCommission(commissionResume);
        closeReportResumeDTO.setTotal(totalResume);
        closeReportResumeDTO.setItems(closeReportDTOS);

        return closeReportResumeDTO;
    }

    public DayReportResumeDTO dayReport(){

        List<Appointment> appointments = appointmentRepository.findAll();
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionItem> transactionItems = transactionItemRepository.findAll();
        List<DayReportDTO> dayReportDTOS = new ArrayList<>();

        int customersServed = 0;
        int rescheduledAppointments = 0;
        int nextDayAppointments = 0;
        int tickets = 0;
        BigDecimal avgTicket = new BigDecimal(0);
        BigDecimal salesTotal = new BigDecimal(0);

        for (Transaction transaction : transactions) {
            if (transaction.getReason() == "1" && transaction.getInvoice() != null && transaction.getInvoice() != "0") {
                customersServed ++;
            }

            if (transaction.getReason() == "1") {
                tickets ++;
            }
        }

        for (Appointment appointment : appointments) {
            if (appointment.getRescheduled()) {
                rescheduledAppointments ++;
            }
            if (appointment.getDate().toLocalDate() == LocalDate.now().plus(1, ChronoUnit.DAYS)) {
                nextDayAppointments ++;
            }
        }

        for (TransactionItem item : transactionItems) {
            DayReportDTO dayReportDTO = new DayReportDTO();
            dayReportDTO.setReason(item.getTransaction().getReason());
            dayReportDTO.setDate(item.getTransaction().getDate());
            if (item.getProduct() != null) {
                dayReportDTO.setProductId(item.getProduct().getId());
                dayReportDTO.setProductName(item.getProduct().getName());
                dayReportDTO.setCommision(item.getProduct().getCommission());
                dayReportDTO.setConcept(item.getProduct().getName());
            }
            if (item.getService() != null) {
                dayReportDTO.setServiceId(item.getService().getId());
                dayReportDTO.setServiceName(item.getService().getName());
                dayReportDTO.setCommision(item.getService().getCommission());
                dayReportDTO.setConcept(item.getService().getName());
            }
            dayReportDTO.setQuantity(item.getQuantity());
            dayReportDTO.setPrice(item.getPrice());
            dayReportDTO.setTotal(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
            salesTotal = salesTotal.add(dayReportDTO.getTotal());
            if (item.getTransaction().getClient() != null) {
                dayReportDTO.setClientId(item.getTransaction().getClient().getId());
                dayReportDTO.setClientName(item.getTransaction().getClient().getName());
            }
            if(item.getEmployee() != null){
                dayReportDTO.setEmployeeId(item.getEmployee().getId());
                dayReportDTO.setEmployeeName(item.getEmployee().getName());
            }
            if (item.getTransaction().getSubsidiary() != null) {
                dayReportDTO.setSubsidiaryId(item.getTransaction().getSubsidiary().getId());
                dayReportDTO.setSubsidiaryName(item.getTransaction().getSubsidiary().getName());
            }

            dayReportDTOS.add(dayReportDTO);

            avgTicket = salesTotal.divide(new BigDecimal(tickets).setScale(0,BigDecimal.ROUND_UP));
        }

        DayReportResumeDTO dayReportResumeDTO = new DayReportResumeDTO();
        dayReportResumeDTO.setCustomersServed(customersServed);
        dayReportResumeDTO.setRescheduledAppointments(rescheduledAppointments);
        dayReportResumeDTO.setNextDayAppointments(nextDayAppointments);
        dayReportResumeDTO.setAvgTicket(avgTicket);
        dayReportResumeDTO.setSalesTotal(salesTotal);
        dayReportResumeDTO.setItems(dayReportDTOS);

        return dayReportResumeDTO;
    }

    public List<AppointmentsReportDTO> appointmentsReport(){
        List<AppointmentItem> appointmentItems = appointmentItemRepository.findAll();
        List<AppointmentsReportDTO> appointmentsReportDTOS = new ArrayList<AppointmentsReportDTO>();

        for (AppointmentItem item: appointmentItems) {
            AppointmentsReportDTO appointmentsReportDTO = new AppointmentsReportDTO();

            appointmentsReportDTO.setAppointmentId(item.getAppointment().getId());
            appointmentsReportDTO.setAppointmentItemId(item.getId());
            appointmentsReportDTO.setStatus(item.getStatus());
            appointmentsReportDTO.setTime(item.getTime());
            appointmentsReportDTO.setServiceName(item.getService().getName());
            appointmentsReportDTO.setClientName(item.getAppointment().getClient().getName());
            appointmentsReportDTO.setEmployeeName(item.getEmployee().getName());
            appointmentsReportDTO.setSubsidiaryName(item.getAppointment().getSubsidiary().getName());

            appointmentsReportDTOS.add(appointmentsReportDTO);
        }

        return appointmentsReportDTOS;
    }

    public List<AppointmentsInProgressReportDTO> appointmentsInProgressReport(){
        List<AppointmentItem> appointmentItems = appointmentItemRepository.findAll();
        List<AppointmentsInProgressReportDTO> appointmentsInProgressReportDTOS =
                new ArrayList<AppointmentsInProgressReportDTO>();

        for (AppointmentItem item: appointmentItems) {
            if(item.getStatus() == StatusEnum.Iniciada) {
                AppointmentsInProgressReportDTO appointmentsInProgressReportDTO = new AppointmentsInProgressReportDTO();

                appointmentsInProgressReportDTO.setAppointmentId(item.getAppointment().getId());
                appointmentsInProgressReportDTO.setAppointmentItemId(item.getId());
                appointmentsInProgressReportDTO.setStatus(item.getStatus());
                appointmentsInProgressReportDTO.setStarted(item.getStarted());

                int diff = (int) (OffsetDateTime.now().toEpochSecond() - item.getStarted().toEpochSecond()) / 60;
                int left = Integer.parseInt(item.getService().getTime()) - diff;
                appointmentsInProgressReportDTO.setMinutesLeft(left);

                appointmentsInProgressReportDTO.setServiceName(item.getService().getName());
                appointmentsInProgressReportDTO.setClientName(item.getAppointment().getClient().getName());
                if (item.getEmployee() != null) {
                    appointmentsInProgressReportDTO.setEmployeeName(item.getEmployee().getName());
                }
                appointmentsInProgressReportDTO.setSubsidiaryName(item.getAppointment().getSubsidiary().getName());

                appointmentsInProgressReportDTOS.add(appointmentsInProgressReportDTO);
            }
        }

        return appointmentsInProgressReportDTOS;
    }

}
