package com.shio.admin.rest;

import com.shio.admin.DTO.AppointmentItemDTO;
import com.shio.admin.domain.AppointmentItem;
import com.shio.admin.service.AppointmentItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/appointment-items")
public class AppointmentItemController {

    private AppointmentItemService appointmentItemService;

    @GetMapping("/{appointment_id}")
    public List<AppointmentItem> getAllByAppointment(@PathVariable("appointment_id") Long appointmentId){
        return appointmentItemService.getAllByAppointment(appointmentId);
    }

    @GetMapping("/{appointment_id}/{id}")
    public List<AppointmentItem> getAllByAppointmentAndId(@PathVariable("appointment_id") Long appointmentId,
                                                          @PathVariable("id") Long id){
        return appointmentItemService.getAllByAppointmentAndId(appointmentId, id);
    }

    @PostMapping
    public AppointmentItem create(@RequestBody AppointmentItemDTO appointmentItem){
        return appointmentItemService.create(appointmentItem);
    }

    @PutMapping
    public AppointmentItem update(@RequestBody AppointmentItemDTO appointmentItem){
        return appointmentItemService.update(appointmentItem);
    }

}
