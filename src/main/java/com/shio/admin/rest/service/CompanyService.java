package com.shio.admin.rest.service;

import com.shio.admin.domain.Company;
import com.shio.admin.persistence.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public List<Company> getAll(){
        return companyRepository.findAll();
    }

}
