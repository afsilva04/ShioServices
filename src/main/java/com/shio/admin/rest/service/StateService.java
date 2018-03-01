package com.shio.admin.rest.service;

import com.shio.admin.domain.State;
import com.shio.admin.persistence.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StateService {

    private final StateRepository stateRepository;

    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public List<State> getStatesByCountry(long countryId) {
        return stateRepository.findAllByCountry(countryId);
    }

}
