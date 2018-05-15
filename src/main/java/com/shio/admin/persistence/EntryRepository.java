package com.shio.admin.persistence;

import com.shio.admin.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {

    List<Entry> findAllBySubsidiaryId(Long subsidiary);
}
