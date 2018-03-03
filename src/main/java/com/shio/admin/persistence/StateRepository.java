package com.shio.admin.persistence;

import com.shio.admin.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findAllByCountryId(long id);

}
