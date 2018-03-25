package com.shio.admin.mappers;

import com.shio.admin.DTO.CouponDTO;
import com.shio.admin.domain.Coupon;
import com.shio.admin.persistence.ClientRepository;
import com.shio.admin.persistence.CouponRepository;
import com.shio.admin.persistence.ProductRepository;
import com.shio.admin.persistence.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CouponMapper {

    private ProductRepository productRepository;
    private ServiceRepository serviceRepository;
    private ClientRepository clientRepository;

    public CouponDTO toDTO(Coupon coupon){

        CouponDTO couponDTO = new CouponDTO();

        couponDTO.setId(coupon.getId());
        couponDTO.setCode(coupon.getCode());
        couponDTO.setQuantity(coupon.getQuantity());
        couponDTO.setAvailable(coupon.getAvailable());
        couponDTO.setTransactionorigin(coupon.getTransactionorigin());
        couponDTO.setTransactionused(coupon.getTransactionused());

        if(coupon.getProduct() != null) {
            couponDTO.setProductId(coupon.getProduct().getId());
            couponDTO.setProductName(coupon.getProduct().getName());
        }

        if(coupon.getService() != null) {
            couponDTO.setServiceId(coupon.getService().getId());
            couponDTO.setServiceName(coupon.getService().getName());
        }

        if(coupon.getClient() != null) {
            couponDTO.setClientId(coupon.getClient().getId());
            couponDTO.setClientName(coupon.getClient().getName());
        }

        return couponDTO;

    }

    public Coupon toEntity(CouponDTO couponDTO){

        Coupon coupon = new Coupon();

        coupon.setId(couponDTO.getId());
        coupon.setCode(couponDTO.getCode());
        coupon.setQuantity(couponDTO.getQuantity());
        coupon.setAvailable(couponDTO.getAvailable());
        coupon.setTransactionorigin(couponDTO.getTransactionorigin());
        coupon.setTransactionused(couponDTO.getTransactionused());

        if(couponDTO.getProductId() != null && couponDTO.getProductId() != 0)
            coupon.setProduct(productRepository.findOne(couponDTO.getProductId()));
        else
            coupon.setProduct(null);

        if(couponDTO.getServiceId() != null && couponDTO.getServiceId() != 0)
            coupon.setService(serviceRepository.findOne(couponDTO.getServiceId()));
        else
            coupon.setService(null);

        if(couponDTO.getClientId() != null && couponDTO.getClientId() != 0)
            coupon.setClient(clientRepository.findOne(couponDTO.getClientId()));
        else
            coupon.setClient(null);

        return coupon;

    }

}
