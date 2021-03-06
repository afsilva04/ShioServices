package com.shio.admin.mappers;

import com.shio.admin.DTO.CouponDTO;
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
        transactionItemDTO.setAnticipated(transactionItem.getAnticipated());
        transactionItemDTO.setCoupon(transactionItem.getCoupon());
        transactionItemDTO.setDateused(transactionItem.getDateused());

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
        transactionItem.setAnticipated(transactionItemDTO.getAnticipated());
        transactionItem.setCoupon(transactionItemDTO.getCoupon());
        transactionItem.setDateused(transactionItemDTO.getDateused());

        if (transactionItemDTO.getProductId() != null && transactionItemDTO.getProductId() != 0)
            transactionItem.setProduct(productRepository.findById(transactionItemDTO.getProductId()).get());
        else
            transactionItem.setProduct(null);

        if (transactionItemDTO.getServiceId() != null && transactionItemDTO.getServiceId() != 0)
            transactionItem.setService(serviceRepository.findById(transactionItemDTO.getServiceId()).get());
        else
            transactionItem.setService(null);

        if (transactionItemDTO.getEmployeeId() != null && transactionItemDTO.getEmployeeId() != 0)
            transactionItem.setEmployee(employeeRepository.findById(transactionItemDTO.getEmployeeId()).get());
        else
            transactionItem.setEmployee(null);

        transactionItem.setTransaction(transactionRepository.findById(transactionItemDTO.getTransactionId()).get());

        return transactionItem;

    }

    public CouponDTO toCouponDTO(TransactionItem transactionItem){

        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCode(transactionItem.getCoupon());
        return couponDTO;

    }

}
