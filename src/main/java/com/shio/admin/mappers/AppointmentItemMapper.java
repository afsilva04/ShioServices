package com.shio.admin.mappers;

import com.shio.admin.DTO.AppointmentItemDTO;
import com.shio.admin.DTO.AppointmentViewDTO;
import com.shio.admin.domain.Appointment;
import com.shio.admin.domain.AppointmentItem;
import com.shio.admin.persistence.AppointmentRepository;
import com.shio.admin.persistence.EmployeeRepository;
import com.shio.admin.persistence.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AppointmentItemMapper {

    private AppointmentRepository appointmentRepository;
    private ServiceRepository serviceRepository;
    private EmployeeRepository employeeRepository;

    public AppointmentItem toEntity(AppointmentItemDTO appointmentItemDTO){

        AppointmentItem appointmentItem = new AppointmentItem();

        appointmentItem.setId(appointmentItemDTO.getId());
        appointmentItem.setTime(appointmentItemDTO.getTime());
        appointmentItem.setStatus(appointmentItemDTO.getStatus());
        appointmentItem.setAppointment(appointmentRepository.findOne(appointmentItemDTO.getAppointmentId()));
        appointmentItem.setService(serviceRepository.findOne(appointmentItemDTO.getServiceId()));
        if(appointmentItemDTO.getEmployeeId() != null && appointmentItemDTO.getEmployeeId() != null)
            appointmentItem.setEmployee(employeeRepository.findOne(appointmentItemDTO.getEmployeeId()));
        else
            appointmentItem.setEmployee(null);

        return appointmentItem;

    }

    public AppointmentItemDTO toDTO(AppointmentItem appointmentItem){

        AppointmentItemDTO appointmentItemDTO = new AppointmentItemDTO();

        appointmentItemDTO.setId(appointmentItem.getId());
        appointmentItemDTO.setTime(appointmentItem.getTime());
        appointmentItemDTO.setStatus(appointmentItem.getStatus());
        appointmentItemDTO.setServiceId(appointmentItem.getService().getId());
        appointmentItemDTO.setServiceName(appointmentItem.getService().getName());
        if(appointmentItem.getEmployee() != null) {
            appointmentItemDTO.setEmployeeId(appointmentItem.getEmployee().getId());
            appointmentItemDTO.setEmployeeName(appointmentItem.getEmployee().getName());
        }
        appointmentItemDTO.setAppointmentId(appointmentItem.getAppointment().getId());

        return appointmentItemDTO;

    }

}
