package com.shio.admin.persistence;

import com.shio.admin.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Coupon findOneByCode(String code);
    List<Coupon> findAllByAvailableGreaterThan(int available);

}
