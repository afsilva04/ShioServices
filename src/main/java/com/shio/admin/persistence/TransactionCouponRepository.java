package com.shio.admin.persistence;

import com.shio.admin.domain.TransactionCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionCouponRepository extends JpaRepository<TransactionCoupon, Long> {

    List<TransactionCoupon> findAllByTransactionId(Long transactionId);
    List<TransactionCoupon> findAllByTransactionIdAndId(Long transactionId, Long id);

}
