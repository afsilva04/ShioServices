package com.shio.admin.rest;

import com.shio.admin.DTO.CouponDTO;
import com.shio.admin.DTO.TransactionCouponDTO;
import com.shio.admin.domain.TransactionCoupon;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.service.TransactionCouponService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/transaction-coupons")
public class TransactionCouponController {

    private TransactionCouponService transactionCouponService;

    @GetMapping("/{transaction_id}")
    public List<TransactionCouponDTO> getAll(@PathVariable("transaction_id") Long transactionId){
        return transactionCouponService.getAllByTransaction(transactionId);
    }

    @GetMapping("/{transaction_id}/{id}")
    public List<TransactionCoupon> getSingle(@PathVariable("transaction_id") Long transactionId,
                                             @PathVariable("id") Long id){
        return transactionCouponService.getAllByTransactionAndId(transactionId, id);
    }

    @PostMapping
    public TransactionCoupon create(@RequestBody TransactionCouponDTO transactionCouponDTO){
        return transactionCouponService.create(transactionCouponDTO);
    }

    @PutMapping
    public TransactionCoupon update(@RequestBody TransactionCouponDTO transactionCouponDTO){
        return transactionCouponService.update(transactionCouponDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        transactionCouponService.delete(id);
    }

    @GetMapping("/active")
    public List<CouponDTO> getActiveCoupons(){
        return transactionCouponService.getActiveCoupons();
    }

}
