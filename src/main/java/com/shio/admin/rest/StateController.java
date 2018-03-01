package com.shio.admin.rest;

import com.shio.admin.domain.State;
import com.shio.admin.rest.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/states")
public class StateController {

    private final StateService stateService;

    @GetMapping()
    public List<State> getAll() {
        return stateService.getStates();
    }

    @GetMapping("/{country_id}")
    public List<State> getAllByCountry(@PathVariable("country_id") long countryId) {
        return stateService.getStatesByCountry(countryId);
    }

}
