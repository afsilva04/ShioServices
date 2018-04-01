package com.shio.admin.mappers;

import com.shio.admin.DTO.TransactionCouponDTO;
import com.shio.admin.domain.TransactionCoupon;
import com.shio.admin.persistence.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransactionCouponMapper {

    private TransactionRepository transactionRepository;

    public TransactionCouponDTO toDTO(TransactionCoupon transactionCoupon){

        TransactionCouponDTO transactionCouponDTO = new TransactionCouponDTO();

        transactionCouponDTO.setId(transactionCoupon.getId());
        transactionCouponDTO.setCode(transactionCoupon.getCode());
        transactionCouponDTO.setTransactionId(transactionCoupon.getTransaction().getId());

        return transactionCouponDTO;

    }

    public TransactionCoupon toEntity(TransactionCouponDTO transactionCouponDTO){

        TransactionCoupon transactionCoupon = new TransactionCoupon();

        transactionCoupon.setId(transactionCouponDTO.getId());
        transactionCoupon.setCode(transactionCouponDTO.getCode());
        transactionCoupon.setTransaction(transactionRepository.findById(transactionCouponDTO.getTransactionId()).get());

        return transactionCoupon;

    }

}