package com.shio.admin.persistence;

import com.shio.admin.domain.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionItemRepository extends JpaRepository<TransactionItem, Long> {

    List<TransactionItem> findAllByTransactionId(Long transactionId);
    List<TransactionItem> findAllByTransactionIdAndId(Long transactionId, Long id);
    List<TransactionItem> findAllByAnticipatedTrueAndCouponNotNullAndDateusedIsNull();
    List<TransactionItem> findAllByAnticipatedTrue();

    @Query(value = "SELECT i.* FROM TransactionItem i INNER JOIN transaction t ON i.transaction_id = t.id WHERE t.subsidiary_id = :subsidiaryId", nativeQuery = true)
    List<TransactionItem> queryAllBySubsidiaryId(Long subsidiaryId);
}
