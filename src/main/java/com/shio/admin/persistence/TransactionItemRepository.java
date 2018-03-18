package com.shio.admin.persistence;

import com.shio.admin.domain.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionItemRepository extends JpaRepository<TransactionItem, Long> {

    List<TransactionItem> findAllByTransactionId(Long transactionId);
    List<TransactionItem> findAllByTransactionIdAndId(Long transactionId, Long id);
    List<TransactionItem> findAllByAnticipatedTrueAndCouponNotNullAndDateusedIsNull();
    List<TransactionItem> findAllByAnticipatedTrue();

}
