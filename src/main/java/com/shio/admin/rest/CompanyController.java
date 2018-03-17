package com.shio.admin.rest;

import com.shio.admin.DTO.CompanyDTO;
import com.shio.admin.domain.Company;
import com.shio.admin.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @GetMapping
    public List<CompanyDTO> getAll(){
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public CompanyDTO getSingle(@PathVariable("id") long id){
        return companyService.getSingle(id);
    }

}
