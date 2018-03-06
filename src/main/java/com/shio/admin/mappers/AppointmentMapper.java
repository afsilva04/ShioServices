package com.shio.admin.mappers;

import com.shio.admin.DTO.AppointmentDTO;
import com.shio.admin.domain.Appointment;
import com.shio.admin.persistence.ClientRepository;
import com.shio.admin.persistence.SubsidiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AppointmentMapper {

    private ClientRepository clientRepository;
    private SubsidiaryRepository subsidiaryRepository;

    public Appointment toEntity(AppointmentDTO appointmentDTO){

        Appointment appointment = new Appointment();

        appointment.setId(appointmentDTO.getId());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setNote(appointmentDTO.getNote());
        appointment.setRescheduled(appointmentDTO.getRescheduled());
        appointment.setClient(clientRepository.findOne(appointmentDTO.getClientId()));
        appointment.setSubsidiary(subsidiaryRepository.findById(appointmentDTO.getSubsidiaryId()));

        return appointment;

    }

}
