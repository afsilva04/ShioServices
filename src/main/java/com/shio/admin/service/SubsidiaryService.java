package com.shio.admin.service;

import com.shio.admin.domain.Subsidiary;
import com.shio.admin.persistence.SubsidiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubsidiaryService {

    private SubsidiaryRepository subsidiaryRepository;

    public List<Subsidiary> getAll(){
        return subsidiaryRepository.findAll();
    }

    public Subsidiary getOne(long id){
        return subsidiaryRepository.findById(id);
    }
}
