package com.shio.admin.mappers;

import com.shio.admin.DTO.SubsidiaryDTO;
import com.shio.admin.domain.Subsidiary;
import org.springframework.stereotype.Component;

@Component
public class SubsidiaryMapper {

    public SubsidiaryDTO toDTO(Subsidiary subsidiary){

        SubsidiaryDTO subsidiaryDTO = new SubsidiaryDTO();

        subsidiaryDTO.setId(subsidiary.getId());
        subsidiaryDTO.setName(subsidiary.getName());
        subsidiaryDTO.setEmail(subsidiary.getEmail());
        subsidiaryDTO.setPhone(subsidiary.getPhone());
        subsidiaryDTO.setMobile(subsidiary.getMobile());
        subsidiaryDTO.setLocation(subsidiary.getLocation());
        subsidiaryDTO.setColony(subsidiary.getColony());
        subsidiaryDTO.setAddress(subsidiary.getAddress());
        subsidiaryDTO.setZip(subsidiary.getZip());
        subsidiaryDTO.setActive(subsidiary.getActive());
        subsidiaryDTO.setCompanyId(subsidiary.getCompany().getId());
        subsidiaryDTO.setCompanyName(subsidiary.getCompany().getName());
        subsidiaryDTO.setCountryId(subsidiary.getCity().getState().getCountry().getId());
        subsidiaryDTO.setCountryName(subsidiary.getCity().getState().getCountry().getName());
        subsidiaryDTO.setStateId(subsidiary.getCity().getState().getId());
        subsidiaryDTO.setStateName(subsidiary.getCity().getState().getName());
        subsidiaryDTO.setCityId(subsidiary.getCity().getId());
        subsidiaryDTO.setCityName(subsidiary.getCity().getName());

        return subsidiaryDTO;

    }

}
