package com.shio.admin.mappers;

import com.shio.admin.DTO.AppointmentCreateDTO;
import com.shio.admin.DTO.AppointmentViewDTO;
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

    public Appointment toEntity(AppointmentCreateDTO appointmentDTO){

        Appointment appointment = new Appointment();

        appointment.setId(appointmentDTO.getId());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setNote(appointmentDTO.getNote());
        appointment.setRescheduled(appointmentDTO.getRescheduled());
        appointment.setClient(clientRepository.findOne(appointmentDTO.getClientId()));
        appointment.setSubsidiary(subsidiaryRepository.findOne(appointmentDTO.getSubsidiaryId()));

        return appointment;

    }

    public AppointmentViewDTO EntityToViewDTO(Appointment appointment){

        AppointmentViewDTO appointmentViewDTO = new AppointmentViewDTO();

        appointmentViewDTO.setId(appointment.getId());
        appointmentViewDTO.setDate(appointment.getDate());
        appointmentViewDTO.setNote(appointment.getNote());
        appointmentViewDTO.setRescheduled(appointment.getRescheduled());
        appointmentViewDTO.setClientId(appointment.getClient().getId());
        appointmentViewDTO.setClientName(appointment.getClient().getName());
        appointmentViewDTO.setSubsidiaryId(appointment.getSubsidiary().getId());
        appointmentViewDTO.setSubsidiaryName(appointment.getSubsidiary().getName());

        return appointmentViewDTO;

    }

}
