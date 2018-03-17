package com.shio.admin.persistence;

import com.shio.admin.domain.EntryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryItemRepository extends JpaRepository<EntryItem, Long>{

    List<EntryItem> findAllByEntryId(Long entryId);
    List<EntryItem> findAllByEntryIdAndId(Long entryId, Long id);

}
