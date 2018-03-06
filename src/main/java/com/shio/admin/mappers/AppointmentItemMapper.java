package com.shio.admin.mappers;

import com.shio.admin.DTO.AppointmentItemDTO;
import com.shio.admin.domain.AppointmentItem;
import com.shio.admin.persistence.AppointmentRepository;
import com.shio.admin.persistence.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AppointmentItemMapper {

    private AppointmentRepository appointmentRepository;
    private ServiceRepository serviceRepository;

    public AppointmentItem toEntity(AppointmentItemDTO appointmentItemDTO){

        AppointmentItem appointmentItem = new AppointmentItem();

        appointmentItem.setId(appointmentItemDTO.getId());
        appointmentItem.setTime(appointmentItemDTO.getTime());
        appointmentItem.setStatus(appointmentItemDTO.getStatus());
        appointmentItem.setAppointment(appointmentRepository.findOne(appointmentItemDTO.getAppointmentId()));
        appointmentItem.setService(serviceRepository.findOne(appointmentItemDTO.getServiceId()));

        return appointmentItem;

    }

}
