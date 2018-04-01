package com.shio.admin.service;

import com.shio.admin.DTO.AppointmentsReportDTO;
import com.shio.admin.DTO.SalesReportDTO;
import com.shio.admin.domain.AppointmentItem;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.persistence.AppointmentItemRepository;
import com.shio.admin.persistence.TransactionItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ReportService {

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

    public List<SalesReportDTO> closeReport(){

        List<TransactionItem> transactionItems = transactionItemRepository.findAll();
        List<SalesReportDTO> salesReportDTOS = new ArrayList<>();

        for (TransactionItem item : transactionItems) {
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

        return salesReportDTOS;
    }

    public List<SalesReportDTO> dayReport(){

        List<TransactionItem> transactionItems = transactionItemRepository.findAll();
        List<SalesReportDTO> salesReportDTOS = new ArrayList<>();

        for (TransactionItem item : transactionItems) {
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

        return salesReportDTOS;
    }

    public List<AppointmentsReportDTO> appointmentsReport(){
        List<AppointmentItem> appointmentItems = appointmentItemRepository.findAll();
        List<AppointmentsReportDTO> appointmentsReportDTOS = new ArrayList<AppointmentsReportDTO>();

        for (AppointmentItem item: appointmentItems) {
            AppointmentsReportDTO appointmentsReportDTO = new AppointmentsReportDTO();
            appointmentsReportDTO.setStatus(item.getStatus());
            appointmentsReportDTO.setTime(item.getTime());
            appointmentsReportDTO.setServiceName(item.getService().getName());
            appointmentsReportDTO.setClientName(item.getAppointment().getClient().getName());
            appointmentsReportDTO.setSubsidiaryName(item.getAppointment().getSubsidiary().getName());
            appointmentsReportDTOS.add(appointmentsReportDTO);
        }

        return appointmentsReportDTOS;
    }

}
