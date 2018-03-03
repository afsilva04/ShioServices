package com.shio.admin.rest;

import com.shio.admin.domain.Subsidiary;
import com.shio.admin.rest.service.SubsidiaryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/subsidiaries")
public class SubsidiaryController {

    private SubsidiaryService subsidiaryService;

    @GetMapping
    public List<Subsidiary> getAll(){
        return subsidiaryService.getAll();
    }

    @GetMapping("/{id}")
    public Subsidiary getOne(@PathVariable("id") long id){
        return subsidiaryService.getOne(id);
    }

}
