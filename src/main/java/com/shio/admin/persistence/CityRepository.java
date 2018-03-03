package com.shio.admin.persistence;

import com.shio.admin.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author afsilva
 */
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByStateId(long id);

}
