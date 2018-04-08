package com.shio.admin.mappers;

import com.shio.admin.domain.Client;
import com.shio.admin.DTO.ClientDTO;
import com.shio.admin.persistence.CityRepository;
import com.shio.admin.persistence.CountryRepository;
import com.shio.admin.persistence.StateRepository;
import com.shio.admin.persistence.SubsidiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author afsilva
 */
@AllArgsConstructor
@Component
public class ClientMapper {

    private CountryRepository countryRepository;
    private StateRepository stateRepository;
    private CityRepository cityRepository;
    private SubsidiaryRepository subsidiaryRepository;

    public ClientDTO getClientDTO(Client client){

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setMobile(client.getMobile());
        clientDTO.setBirthdate(client.getBirthdate());
        if(client.getCountry() != null) {
            clientDTO.setCountryId(client.getCountry().getId());
            clientDTO.setCountryName(client.getCountry().getName());
        }
        if(client.getState() != null) {
            clientDTO.setStateId(client.getState().getId());
            clientDTO.setStateName(client.getState().getName());
        }
        if(client.getCity() != null) {
            clientDTO.setCityId(client.getCity().getId());
            clientDTO.setCityName(client.getCity().getName());
        }
        clientDTO.setLocation(client.getLocation());
        clientDTO.setColony(client.getColony());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setZip(client.getZip());
        clientDTO.setRfc(client.getRfc());
        if(client.getSubsidiary() != null) {
            clientDTO.setSubsidiaryId(client.getSubsidiary().getId());
            clientDTO.setSubsidiaryName(client.getSubsidiary().getName());
        }
        clientDTO.setActive(client.getActive());
        clientDTO.setSearchText(client.getMobile() + " - " + client.getName());

        return clientDTO;
    }

    public Client toEntity(ClientDTO clientDTO) {

        Client client = new Client();

        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setMobile(clientDTO.getMobile());
        client.setBirthdate(clientDTO.getBirthdate());
        if(clientDTO.getCountryId() != null && clientDTO.getCountryId() != 0)
            client.setCountry(countryRepository.findById(clientDTO.getCountryId()).get());
        if(clientDTO.getStateId() != null && clientDTO.getStateId() != 0)
            client.setState(stateRepository.findById(clientDTO.getStateId()).get());
        if(clientDTO.getCityId() != null && clientDTO.getCityId() != 0)
            client.setCity(cityRepository.findById(clientDTO.getCityId()).get());
        client.setLocation(clientDTO.getLocation());
        client.setColony(clientDTO.getColony());
        client.setAddress(clientDTO.getAddress());
        client.setZip(clientDTO.getZip());
        client.setRfc(clientDTO.getRfc());
        if(clientDTO.getSubsidiaryId() != null && clientDTO.getSubsidiaryId() != 0)
            client.setSubsidiary(subsidiaryRepository.findById(clientDTO.getSubsidiaryId()).get());
        client.setActive(clientDTO.getActive());

        return client;
    }

}
