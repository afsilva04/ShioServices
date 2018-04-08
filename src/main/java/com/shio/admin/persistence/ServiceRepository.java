package com.shio.admin.persistence;

import com.shio.admin.domain.Sservice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Sservice, Long> {

    List<Sservice> findByNameContainingIgnoreCase(String name);

}
