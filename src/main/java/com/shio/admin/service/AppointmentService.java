package com.shio.admin.service;

import com.shio.admin.DTO.AppointmentCreateDTO;
import com.shio.admin.DTO.AppointmentViewDTO;
import com.shio.admin.DTO.TransactionDTO;
import com.shio.admin.domain.Appointment;
import com.shio.admin.domain.Transaction;
import com.shio.admin.mappers.AppointmentMapper;
import com.shio.admin.persistence.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private AppointmentMapper appointmentMapper;
    private TransactionService transactionService;

    public List<AppointmentViewDTO> getAll(){
        return appointmentRepository.findAll().stream()
                .map(a -> appointmentMapper.EntityToViewDTO(a))
                .collect(Collectors.toList());
    }

    /*public List<Appointment> getAllByDate(String date){
        return appointmentRepository.findAllByDate(date);
    }*/

    public AppointmentViewDTO getSingle(Long id){
        return appointmentMapper.EntityToViewDTO(appointmentRepository.findOne(id));
    }

    public Appointment create(AppointmentCreateDTO appointment){
        //return appointmentRepository.save(appointment);
        return appointmentRepository.save(appointmentMapper.toEntity(appointment));
    }

    public Appointment update(AppointmentCreateDTO appointment){
        return appointmentRepository.save(appointmentMapper.toEntity(appointment));
    }

    public Transaction createTransaction(Long id){
        Appointment appointment = appointmentRepository.findOne(id);

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setDate(LocalDate.now().toString());
        transactionDTO.setReasonId("1"); //Venta
        transactionDTO.setClientId(appointment.getClient().getId());
        transactionDTO.setSubsidiaryId(appointment.getSubsidiary().getId());

        Transaction transaction = transactionService.create(transactionDTO);

        return transaction;
    }

}
