package com.shio.admin.service;

import com.shio.admin.DTO.CouponDTO;
import com.shio.admin.DTO.TransactionItemDTO;
import com.shio.admin.domain.Coupon;
import com.shio.admin.domain.Transaction;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.mappers.CouponMapper;
import com.shio.admin.mappers.TransactionItemMapper;
import com.shio.admin.persistence.CouponRepository;
import com.shio.admin.persistence.TransactionItemRepository;
import com.shio.admin.persistence.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CouponService {

    private CouponRepository couponRepository;
    private CouponMapper couponMapper;
    private TransactionRepository transactionRepository;
    private TransactionItemRepository transactionItemRepository;
    private TransactionItemMapper transactionItemMapper;

    public List<CouponDTO> getAll(){
        return couponRepository.findAll()
                .stream()
                .map(c -> couponMapper.toDTO(c))
                .collect(Collectors.toList());
    }

    public CouponDTO getSingle(Long id){
        return couponMapper.toDTO(couponRepository.findOne(id));
    }

    public List<CouponDTO> getAvailable(){
        return couponRepository.findAllByAvailableGreaterThan(0)
                .stream()
                .map(c -> couponMapper.toDTO(c))
                .collect(Collectors.toList());
    }

    public Coupon create(CouponDTO couponDTO){
        return couponRepository.save(couponMapper.toEntity(couponDTO));
    }

    public Coupon update(CouponDTO couponDTO){
        return couponRepository.save(couponMapper.toEntity(couponDTO));
    }

    public List<CouponDTO> generateCoupons(Long transactionId){
        Transaction transaction = transactionRepository.findOne(transactionId);
        List<TransactionItemDTO> transactionItemDTOS =
                transactionItemRepository.findAllByTransactionId(transactionId)
                        .stream()
                        .map(i -> transactionItemMapper.toDTO(i))
                        .collect(Collectors.toList());

        List<CouponDTO> couponDTOS = new ArrayList<>();
        for (TransactionItemDTO item : transactionItemDTOS) {
            if(item.getAnticipated() != null && item.getAnticipated()) {
                Coupon coupon = create(generateCoupon(transaction, item));
                couponDTOS.add(couponMapper.toDTO(coupon));

                item.setCoupon(coupon.getCode());
                transactionItemRepository.save(transactionItemMapper.toEntity(item));
            }
        }

        return couponDTOS;
    }

    private CouponDTO generateCoupon(Transaction transaction, TransactionItemDTO transactionItemDTO){

        CouponDTO couponDTO = new CouponDTO();

        Long datetime = System.currentTimeMillis();
        String couponCode = (transaction.getSubsidiary().getName().substring(0, 2).toUpperCase()
                + transaction.getId()
                + "T"
                + transactionItemDTO.getId()
                + "N"
                + datetime.toString());
        couponDTO.setCode(couponCode);

        couponDTO.setQuantity(transactionItemDTO.getQuantity());
        couponDTO.setAvailable(transactionItemDTO.getQuantity());
        couponDTO.setTransactionorigin(transaction.getId());
        couponDTO.setProductId(transactionItemDTO.getProductId());
        couponDTO.setProductName(transactionItemDTO.getProductName());
        couponDTO.setServiceId(transactionItemDTO.getServiceId());
        couponDTO.setServiceName(transactionItemDTO.getServiceName());
        couponDTO.setClientId(transaction.getClient().getId());
        couponDTO.setClientName(transaction.getClient().getName());

        return couponDTO;
    }

    public Coupon substract(String code, int quantity){
        Coupon coupon = couponRepository.findOneByCode(code);
        coupon.setAvailable(coupon.getQuantity() - quantity);
        return couponRepository.save(coupon);
    }

    public Coupon add(String code, int quantity){
        Coupon coupon = couponRepository.findOneByCode(code);
        coupon.setAvailable(coupon.getQuantity() + quantity);
        return couponRepository.save(coupon);
    }

    public void substractByTransaction(Long id){
        List<TransactionItem> transactionItems = transactionItemRepository.findAllByTransactionId(id);
        for (TransactionItem item : transactionItems) {
            if(item.getCoupon() != null && item.getCoupon() != "")
                substract(item.getCoupon(), item.getQuantity());
        }
    }

}
