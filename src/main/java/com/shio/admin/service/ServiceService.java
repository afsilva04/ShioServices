package com.shio.admin.service;

import com.shio.admin.domain.Sservice;
import com.shio.admin.persistence.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ServiceService {

    private ServiceRepository serviceRepository;

    public List<Sservice> getAll(){
        return serviceRepository.findAll();
    }

    public List<Sservice> getServices(String searchTxt){
        if(searchTxt.isEmpty()){
            return serviceRepository.findAll();
        } else {
            return serviceRepository.findByNameContainingIgnoreCase(searchTxt);
        }
    }

    public Sservice getSingle(Long id){
        return serviceRepository.findById(id).get();
    }

    public Sservice create(Sservice sservice){
        return serviceRepository.save(sservice);
    }

    public Sservice update(Sservice sservice){
        return serviceRepository.save(sservice);
    }

}
