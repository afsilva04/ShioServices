package com.shio.admin.rest;

import com.shio.admin.DTO.AppointmentDTO;
import com.shio.admin.domain.Appointment;
import com.shio.admin.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAll(){
        return appointmentService.getAll();
    }

    @GetMapping("/search/{date}")
    public List<Appointment> getAllByDate(@PathVariable("date") String date){
        return appointmentService.getAllByDate(date);
    }

    @GetMapping("/{id}")
    public Appointment getSingle(@PathVariable("id") Long id){
        return appointmentService.getSingle(id);
    }

    @PostMapping
    public Appointment create(@RequestBody AppointmentDTO appointment){
        return appointmentService.create(appointment);
    }

    @PutMapping
    public Appointment update(@RequestBody AppointmentDTO appointment){
        return appointmentService.update(appointment);
    }

}
