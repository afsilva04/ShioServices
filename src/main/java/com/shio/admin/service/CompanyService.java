package com.shio.admin.service;

import com.shio.admin.DTO.CompanyDTO;
import com.shio.admin.domain.Company;
import com.shio.admin.mappers.CompanyMapper;
import com.shio.admin.persistence.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    private CompanyMapper companyMapper;

    public List<CompanyDTO> getAll(){
        return companyRepository.findAll()
                .stream()
                .map(c -> companyMapper.toDTO(c))
                .collect(Collectors.toList());
    }

    public CompanyDTO getSingle(long id) { return  companyMapper.toDTO(companyRepository.findById(id).get()); }

}
