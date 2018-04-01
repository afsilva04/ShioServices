package com.shio.admin.service;

import com.shio.admin.domain.Client;
import com.shio.admin.persistence.CityRepository;
import com.shio.admin.persistence.ClientRepository;
import com.shio.admin.DTO.ClientDTO;
import com.shio.admin.mappers.ClientMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author afsilva
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, CityRepository cityRepository ,ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.cityRepository = cityRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDTO> getAll(){
        return clientRepository.findAll().stream().
                map(n -> clientMapper.getClientDTO(n)).collect(Collectors.toList());
    }

    public ClientDTO getClient(long clientId){
        Client client = clientRepository.findById(clientId).get();
        //City city = cityRepository.findOne(client.getCity().getId());
        //ClientDTO clientDTO = clientMapper.getClientDTOcity(client, city);
        ClientDTO clientDTO = clientMapper.getClientDTO(client);
        return clientDTO;
    }

    public List<ClientDTO> getClients(String searchTxt){
        if(searchTxt.isEmpty()){
            return clientRepository.findAll().stream().
                    map(n -> clientMapper.getClientDTO(n)).collect(Collectors.toList());
        } else {
            return clientRepository.findByNameContainingOrPhoneContaining(searchTxt, searchTxt).stream().
                    map(n -> clientMapper.getClientDTO(n)).collect(Collectors.toList());
        }
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Client updateClient(Client client){
        return clientRepository.save(client);
    }

}
