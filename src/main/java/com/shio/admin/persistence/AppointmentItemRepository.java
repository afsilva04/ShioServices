package com.shio.admin.persistence;

import com.shio.admin.domain.AppointmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentItemRepository extends JpaRepository<AppointmentItem, Long> {

    List<AppointmentItem> findAllByAppointmentId(Long appointmentId);
    List<AppointmentItem> findAllByAppointmentIdAndId(Long appointmentId, Long id);

    @Query(value = "SELECT i.* FROM AppointmentItem i INNER JOIN appointment a ON i.appointment_id = a.id WHERE a.subsidiary_id = :subsidiaryId", nativeQuery = true)
    List<AppointmentItem> queryAllBySubsidiaryId(Long subsidiaryId);
}
