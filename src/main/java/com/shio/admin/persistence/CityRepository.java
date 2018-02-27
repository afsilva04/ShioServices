package com.shio.admin.persistence;

import com.shio.admin.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author afsilva
 */
public interface CityRepository extends JpaRepository<City, Long> {

}
