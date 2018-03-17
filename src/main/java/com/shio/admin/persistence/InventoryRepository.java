package com.shio.admin.persistence;

import com.shio.admin.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findAllBySubsidiaryId(Long subsidiaryId);
    Inventory findByProductIdAndSubsidiaryId(Long productId, Long subsidiaryId);

}
