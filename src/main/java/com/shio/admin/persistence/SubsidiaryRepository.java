package com.shio.admin.persistence;

import com.shio.admin.domain.Subsidiary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubsidiaryRepository extends JpaRepository<Subsidiary, Long> {

    Subsidiary findById(long id);

}
