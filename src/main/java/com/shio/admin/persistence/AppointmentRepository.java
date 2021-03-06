package com.shio.admin.persistence;

import com.shio.admin.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //List<Appointment> findAllByDate(String date);
    List<Appointment> findAllBySubsidiaryId(Long subsidiary);
}
