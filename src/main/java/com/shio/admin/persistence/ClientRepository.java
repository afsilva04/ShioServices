package com.shio.admin.persistence;

import com.shio.admin.domain.Client;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(long id);

    List<Client> findByNameContainingIgnoreCaseOrPhoneContaining(String name, String phone);
}
