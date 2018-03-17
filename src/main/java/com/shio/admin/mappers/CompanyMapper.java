package com.shio.admin.mappers;

import com.shio.admin.DTO.CompanyDTO;
import com.shio.admin.domain.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyDTO toDTO(Company company){

        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setRfc(company.getRfc());
        companyDTO.setCertificate(company.getCertificate());
        companyDTO.setLocation(company.getLocation());
        companyDTO.setColony(company.getColony());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setZip(company.getZip());
        companyDTO.setCountryId(company.getCity().getState().getCountry().getId());
        companyDTO.setCountryName(company.getCity().getState().getCountry().getName());
        companyDTO.setStateId(company.getCity().getState().getId());
        companyDTO.setStateName(company.getCity().getState().getName());
        companyDTO.setCityId(company.getCity().getId());
        companyDTO.setCityName(company.getCity().getName());

        return companyDTO;

    }

}
