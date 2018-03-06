package com.shio.admin.mappers;

import com.shio.admin.domain.Client;
import com.shio.admin.DTO.ClientDTO;
import org.springframework.stereotype.Component;

/**
 * @author afsilva
 */
@Component
public class ClientMapper {

    /*public ClientDTO getClientDTOcity(Client client, City city){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setCountry(client.getCountry());
        clientDTO.setState(client.getState());
        //clientDTO.setCity(client.getCity());
        //clientDTO.setCityTxt(city.getName());
        //clientDTO.setCityTxt(client.getCity().getName());
        clientDTO.setColony(client.getColony());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setZip(client.getZip());
        clientDTO.setRfc(client.getRfc());
        clientDTO.setSubsidiary(client.getSubsidiary());
        return clientDTO;
    }*/

    //(name, email, phone, mobile, birthdate, country, state, city_id, location, colony, address, zip, rfc, subsidiary, active)
    public ClientDTO getClientDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setMobile(client.getMobile());
        clientDTO.setBirthdate(client.getBirthdate());
        clientDTO.setCountryId(client.getCountry().getId());
        clientDTO.setCountryTxt(client.getCountry().getName());
        clientDTO.setStateId(client.getState().getId());
        clientDTO.setStateTxt(client.getState().getName());
        clientDTO.setCityId(client.getCity().getId());
        clientDTO.setCityTxt(client.getCity().getName());
        clientDTO.setLocation(client.getLocation());
        clientDTO.setColony(client.getColony());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setZip(client.getZip());
        clientDTO.setRfc(client.getRfc());
        clientDTO.setSubsidiaryId(client.getSubsidiary().getId());
        clientDTO.setSubsidiaryTxt(client.getSubsidiary().getName());
        clientDTO.setActive(client.getActive());

        return clientDTO;
    }

}
