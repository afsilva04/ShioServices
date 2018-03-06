package com.shio.admin.service;

import com.shio.admin.DTO.AppointmentDTO;
import com.shio.admin.domain.Appointment;
import com.shio.admin.mappers.AppointmentMapper;
import com.shio.admin.persistence.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private AppointmentMapper appointmentMapper;

    public List<Appointment> getAll(){
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAllByDate(String date){
        return appointmentRepository.findAllByDate(date);
    }

    public Appointment getSingle(Long id){
        return appointmentRepository.findOne(id);
    }

    public Appointment create(AppointmentDTO appointment){
        return appointmentRepository.save(appointmentMapper.toEntity(appointment));
    }

    public Appointment update(AppointmentDTO appointment){
        return appointmentRepository.save(appointmentMapper.toEntity(appointment));
    }

}
