package com.shio.admin.rest;

import com.shio.admin.domain.City;
import com.shio.admin.persistence.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/cities")
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping()
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @GetMapping("/{state_id}")
    public List<City> getAllByState(@PathVariable("state_id") long stateId) {
        return cityRepository.findAllByStateId(stateId);
    }

}
