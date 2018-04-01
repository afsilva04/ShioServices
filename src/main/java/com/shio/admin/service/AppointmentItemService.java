package com.shio.admin.service;

import com.shio.admin.DTO.AppointmentItemDTO;
import com.shio.admin.domain.AppointmentItem;
import com.shio.admin.domain.StatusEnum;
import com.shio.admin.mappers.AppointmentItemMapper;
import com.shio.admin.persistence.AppointmentItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AppointmentItemService {

    private AppointmentItemRepository appointmentItemRepository;
    private AppointmentItemMapper appointmentItemMapper;

    public List<AppointmentItemDTO> getAll(){
        return appointmentItemRepository.findAll()
                .stream()
                .map(a -> appointmentItemMapper.toDTO(a))
                .collect(Collectors.toList());
    }

    public List<AppointmentItemDTO> getAllByAppointment(Long appointmentId){
        return appointmentItemRepository.findAllByAppointmentId(appointmentId)
                .stream()
                .map(a -> appointmentItemMapper.toDTO(a))
                .collect(Collectors.toList());
    }

    public List<AppointmentItem> getAllByAppointmentAndId(Long appointmentId, Long id){
        return appointmentItemRepository.findAllByAppointmentIdAndId(appointmentId, id);
    }

    public AppointmentItem create(AppointmentItemDTO appointmentItem){
        if (appointmentItem.getStatus() == StatusEnum.Iniciada)
            appointmentItem.setStarted(OffsetDateTime.now());
        return appointmentItemRepository.save(appointmentItemMapper.toEntity(appointmentItem));
    }

    public AppointmentItem update(AppointmentItemDTO appointmentItem){
        AppointmentItem appointmentItemRepo = appointmentItemRepository.findById(appointmentItem.getId()).get();

        if (appointmentItem.getStatus() == StatusEnum.Iniciada
                && appointmentItemRepo.getStatus() != StatusEnum.Iniciada)
            appointmentItem.setStarted(OffsetDateTime.now());

        return appointmentItemRepository.save(appointmentItemMapper.toEntity(appointmentItem));
    }

    public void delete(Long id){
        appointmentItemRepository.deleteById(id);
    }

}
