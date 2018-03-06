package com.shio.admin.persistence;

import com.shio.admin.domain.AppointmentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentItemRepository extends JpaRepository<AppointmentItem, Long> {

    List<AppointmentItem> findAllByAppointmentId(Long appointmentId);
    List<AppointmentItem> findAllByAppointmentIdAndId(Long appointmentId, Long id);

}
