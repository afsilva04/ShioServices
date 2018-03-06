package com.shio.admin.persistence;

import com.shio.admin.domain.Sservice;
import com.shio.admin.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/services")
public class ServiceController {

    private ServiceService serviceService;

    @GetMapping
    public List<Sservice> getAll(){
        return serviceService.getAll();
    }

    @GetMapping("/{id}")
    public Sservice getSingle(@PathVariable("id") Long id){
        return serviceService.getSingle(id);
    }

    @PostMapping
    public Sservice create(@RequestBody Sservice sservice){
        return serviceService.create(sservice);
    }

    @PutMapping
    public Sservice update(@RequestBody Sservice sservice){
        return serviceService.update(sservice);
    }

}
