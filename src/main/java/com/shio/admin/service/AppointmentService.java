package com.shio.admin.service;

import com.shio.admin.DTO.AppointmentCreateDTO;
import com.shio.admin.DTO.AppointmentViewDTO;
import com.shio.admin.DTO.TransactionDTO;
import com.shio.admin.DTO.TransactionItemDTO;
import com.shio.admin.domain.Appointment;
import com.shio.admin.domain.AppointmentItem;
import com.shio.admin.domain.Transaction;
import com.shio.admin.mappers.AppointmentMapper;
import com.shio.admin.persistence.AppointmentItemRepository;
import com.shio.admin.persistence.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private AppointmentMapper appointmentMapper;
    private TransactionService transactionService;
    private AppointmentItemRepository appointmentItemRepository;
    private TransactionItemService transactionItemService;

    public List<AppointmentViewDTO> getAll(Long subsidiary){
        if (subsidiary ==0) {
            return appointmentRepository.findAll().stream()
                    .map(a -> appointmentMapper.EntityToViewDTO(a))
                    .collect(Collectors.toList());
        } else {
            return appointmentRepository.findAllBySubsidiaryId(subsidiary).stream()
                    .map(a -> appointmentMapper.EntityToViewDTO(a))
                    .collect(Collectors.toList());
        }
    }

    /*public List<Appointment> getAllByDate(String date){
        return appointmentRepository.findAllByDate(date);
    }*/

    public AppointmentViewDTO getSingle(Long id){
        return appointmentMapper.EntityToViewDTO(appointmentRepository.findById(id).get());
    }

    public Appointment create(AppointmentViewDTO appointment){
        //return appointmentRepository.save(appointment);
        return appointmentRepository.save(appointmentMapper.ViewDTOtoEntity(appointment));
    }

    public Appointment update(AppointmentViewDTO appointment){
        return appointmentRepository.save(appointmentMapper.ViewDTOtoEntity(appointment));
    }

    public Transaction createTransaction(Long id){
        Appointment appointment = appointmentRepository.findById(id).get();

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setDate(OffsetDateTime.now());
        transactionDTO.setReasonId("1"); //Venta
        transactionDTO.setClientId(appointment.getClient().getId());
        transactionDTO.setSubsidiaryId(appointment.getSubsidiary().getId());

        Transaction transaction = transactionService.create(transactionDTO);

        if(transaction != null)
            createTransactionItems(id, transaction.getId());

        return transaction;
    }

    private void createTransactionItems(Long appointment, Long transaction){
        List<AppointmentItem> appointmentItems = appointmentItemRepository.findAllByAppointmentId(appointment);

        for (AppointmentItem item : appointmentItems) {
            TransactionItemDTO transactionItemDTO = new TransactionItemDTO();
            transactionItemDTO.setQuantity(1);
            transactionItemDTO.setPrice(item.getService().getPrice());
            transactionItemDTO.setAnticipated(false);
            transactionItemDTO.setServiceId(item.getService().getId());
            if(item.getEmployee() != null){
                transactionItemDTO.setEmployeeId(item.getEmployee().getId());
            }
            transactionItemDTO.setTransactionId(transaction);

            transactionItemService.create(transactionItemDTO);
        }
    }

}
