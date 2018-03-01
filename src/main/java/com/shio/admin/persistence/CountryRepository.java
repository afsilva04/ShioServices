package com.shio.admin.persistence;

import java.util.List;
import com.shio.admin.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findAll();

}
