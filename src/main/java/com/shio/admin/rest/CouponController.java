package com.shio.admin.rest;

import com.shio.admin.DTO.CouponDTO;
import com.shio.admin.domain.Coupon;
import com.shio.admin.service.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/coupons")
public class CouponController {

    private CouponService couponService;

    @GetMapping
    public List<CouponDTO> getAll(){
        return couponService.getAll();
    }

    @GetMapping("/{id}")
    public CouponDTO getSingle(@PathVariable("id") Long id){
        return couponService.getSingle(id);
    }

    @GetMapping("/available")
    public List<CouponDTO> getAvailable(){
        return couponService.getAvailable();
    }

    @PostMapping
    public Coupon create(@RequestBody CouponDTO couponDTO){
        return couponService.create(couponDTO);
    }

    @PutMapping
    public Coupon update(@RequestBody CouponDTO couponDTO){
        return couponService.update(couponDTO);
    }

    @PostMapping("/generate/{transaction_id}")
    public List<CouponDTO> generate(@PathVariable("transaction_id") Long id){
        return couponService.generateCoupons(id);
    }

    @PostMapping("/substract/{code}/{quantity}")
    public void substractInventoryByTransaction(@PathVariable("code") String code,
                                                @PathVariable("quantity") int quantity){
        couponService.substract(code, quantity);
    }

    @PostMapping("/substract/{id_transaction}")
    public void substractByTransaction(@PathVariable("id_transaction") Long id){
        couponService.substractByTransaction(id);
    }

}
