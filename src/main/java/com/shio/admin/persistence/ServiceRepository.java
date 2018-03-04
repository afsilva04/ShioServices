package com.shio.admin.persistence;

import com.shio.admin.domain.Sservice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Sservice, Long> {

}
