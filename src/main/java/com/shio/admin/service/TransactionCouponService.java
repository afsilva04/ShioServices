package com.shio.admin.service;

import com.shio.admin.DTO.CouponDTO;
import com.shio.admin.DTO.TransactionCouponDTO;
import com.shio.admin.domain.TransactionCoupon;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.mappers.TransactionCouponMapper;
import com.shio.admin.mappers.TransactionItemMapper;
import com.shio.admin.persistence.TransactionCouponRepository;
import com.shio.admin.persistence.TransactionItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransactionCouponService {

    private TransactionCouponRepository transactionCouponRepository;
    private TransactionCouponMapper transactionCouponMapper;
    private TransactionItemRepository transactionItemRepository;
    private TransactionItemMapper transactionItemMapper;

    public List<TransactionCouponDTO> getAll(){
        return transactionCouponRepository.findAll()
                .stream()
                .map(c -> transactionCouponMapper.toDTO(c))
                .collect(Collectors.toList());
    }

    public List<TransactionCouponDTO> getAllByTransaction(Long transactionId){
        return transactionCouponRepository.findAllByTransactionId(transactionId)
                .stream()
                .map(a -> transactionCouponMapper.toDTO(a))
                .collect(Collectors.toList());
    }

    public List<TransactionCoupon> getAllByTransactionAndId(Long transactionId, Long id){
        return transactionCouponRepository.findAllByTransactionIdAndId(transactionId, id);
    }

    public TransactionCouponDTO getSingle(Long id){
        return transactionCouponMapper.toDTO(transactionCouponRepository.findById(id).get());
    }

    public TransactionCoupon create (TransactionCouponDTO transactionCouponDTO){
        return transactionCouponRepository.save(transactionCouponMapper.toEntity(transactionCouponDTO));
    }

    public TransactionCoupon update (TransactionCouponDTO transactionCouponDTO){
        return transactionCouponRepository.save(transactionCouponMapper.toEntity(transactionCouponDTO));
    }

    public void delete(Long id){
        transactionCouponRepository.deleteById(id);
    }

    public List<CouponDTO> getActiveCoupons(){
        return transactionItemRepository.findAllByAnticipatedTrueAndCouponNotNullAndDateusedIsNull()
                .stream()
                .map(c -> transactionItemMapper.toCouponDTO(c))
                .collect(Collectors.toList());
    }

}
