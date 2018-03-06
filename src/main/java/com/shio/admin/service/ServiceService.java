package com.shio.admin.service;

import com.shio.admin.domain.Sservice;
import com.shio.admin.persistence.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceService {

    private ServiceRepository serviceRepository;

    public List<Sservice> getAll(){
        return serviceRepository.findAll();
    }

    public Sservice getSingle(Long id){
        return serviceRepository.findOne(id);
    }

    public Sservice create(Sservice sservice){
        return serviceRepository.save(sservice);
    }

    public Sservice update(Sservice sservice){
        return serviceRepository.save(sservice);
    }

}
