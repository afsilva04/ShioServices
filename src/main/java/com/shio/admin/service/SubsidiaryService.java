package com.shio.admin.service;

import com.shio.admin.DTO.SubsidiaryDTO;
import com.shio.admin.domain.Subsidiary;
import com.shio.admin.mappers.SubsidiaryMapper;
import com.shio.admin.persistence.SubsidiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SubsidiaryService {

    private SubsidiaryRepository subsidiaryRepository;
    private SubsidiaryMapper subsidiaryMapper;

    public List<SubsidiaryDTO> getAll(){
        return subsidiaryRepository.findAll()
                .stream()
                .map(s -> subsidiaryMapper.toDTO(s))
                .collect(Collectors.toList());
    }

    public SubsidiaryDTO getOne(long id){
        return subsidiaryMapper.toDTO(subsidiaryRepository.findById(id));
    }
}
