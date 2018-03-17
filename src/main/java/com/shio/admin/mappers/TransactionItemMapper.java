package com.shio.admin.mappers;

import com.shio.admin.DTO.TransactionItemDTO;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.persistence.EmployeeRepository;
import com.shio.admin.persistence.ProductRepository;
import com.shio.admin.persistence.ServiceRepository;
import com.shio.admin.persistence.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransactionItemMapper {

    private ProductRepository productRepository;
    private ServiceRepository serviceRepository;
    private TransactionRepository transactionRepository;
    private EmployeeRepository employeeRepository;

    public TransactionItemDTO toDTO(TransactionItem transactionItem){

        TransactionItemDTO transactionItemDTO = new TransactionItemDTO();

        transactionItemDTO.setId(transactionItem.getId());
        transactionItemDTO.setType(transactionItem.getType());
        transactionItemDTO.setQuantity(transactionItem.getQuantity());
        transactionItemDTO.setPrice(transactionItem.getPrice());
        transactionItemDTO.setAditional(transactionItem.getAditional());

        if (transactionItem.getProduct() != null) {
            transactionItemDTO.setProductId(transactionItem.getProduct().getId());
            transactionItemDTO.setProductName(transactionItem.getProduct().getName());
        }

        if (transactionItem.getService() != null) {
            transactionItemDTO.setServiceId(transactionItem.getService().getId());
            transactionItemDTO.setServiceName(transactionItem.getService().getName());
        }

        if (transactionItem.getEmployee() != null){
            transactionItemDTO.setEmployeeId(transactionItem.getEmployee().getId());
            transactionItemDTO.setEmployeeName(transactionItem.getEmployee().getName());
        }

        transactionItemDTO.setTransactionId(transactionItem.getTransaction().getId());

        return transactionItemDTO;

    }

    public TransactionItem toEntity(TransactionItemDTO transactionItemDTO){

        TransactionItem transactionItem = new TransactionItem();

        transactionItem.setId(transactionItemDTO.getId());
        transactionItem.setType(transactionItemDTO.getType());
        transactionItem.setQuantity(transactionItemDTO.getQuantity());
        transactionItem.setPrice(transactionItemDTO.getPrice());
        transactionItem.setAditional(transactionItemDTO.getAditional());

        if (transactionItemDTO.getProductId() != null && transactionItemDTO.getProductId() != 0)
            transactionItem.setProduct(productRepository.findOne(transactionItemDTO.getProductId()));
        else
            transactionItem.setProduct(null);

        if (transactionItemDTO.getServiceId() != null && transactionItemDTO.getServiceId() != 0)
            transactionItem.setService(serviceRepository.findOne(transactionItemDTO.getServiceId()));
        else
            transactionItem.setService(null);

        if (transactionItemDTO.getEmployeeId() != null && transactionItemDTO.getEmployeeId() != 0)
            transactionItem.setEmployee(employeeRepository.findOne(transactionItemDTO.getEmployeeId()));
        else
            transactionItem.setEmployee(null);

        transactionItem.setTransaction(transactionRepository.findOne(transactionItemDTO.getTransactionId()));

        return transactionItem;

    }

}
