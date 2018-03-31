package com.shio.admin.service;

import com.shio.admin.DTO.SalesReportDTO;
import com.shio.admin.domain.TransactionItem;
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

    public void appointmentsReport(){
        //Inner Join Appointment - AppointmentItems
    }

}
