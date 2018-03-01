package com.shio.admin.rest;

import com.shio.admin.domain.Country;
import com.shio.admin.persistence.CountryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping()
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

}
