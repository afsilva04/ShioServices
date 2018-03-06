package com.shio.admin.service;

import com.shio.admin.DTO.AppointmentItemDTO;
import com.shio.admin.domain.AppointmentItem;
import com.shio.admin.mappers.AppointmentItemMapper;
import com.shio.admin.persistence.AppointmentItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AppointmentItemService {

    private AppointmentItemRepository appointmentItemRepository;
    private AppointmentItemMapper appointmentItemMapper;

    public List<AppointmentItem> getAllByAppointment(Long appointmentId){
        return appointmentItemRepository.findAllByAppointmentId(appointmentId);
    }

    public List<AppointmentItem> getAllByAppointmentAndId(Long appointmentId, Long id){
        return appointmentItemRepository.findAllByAppointmentIdAndId(appointmentId, id);
    }

    public AppointmentItem create(AppointmentItemDTO appointmentItem){
        return appointmentItemRepository.save(appointmentItemMapper.toEntity(appointmentItem));
    }

    public AppointmentItem update(AppointmentItemDTO appointmentItem){
        return appointmentItemRepository.save(appointmentItemMapper.toEntity(appointmentItem));
    }

}
