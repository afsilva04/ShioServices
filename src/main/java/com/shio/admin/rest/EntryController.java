package com.shio.admin.rest;

import com.shio.admin.DTO.EntryDTO;
import com.shio.admin.domain.Entry;
import com.shio.admin.service.EntryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/entries")
public class EntryController {

    private EntryService entryService;

    @GetMapping
    public List<EntryDTO> getAll(){
        return entryService.getAll();
    }

    @GetMapping("/{id}")
    public EntryDTO getSingle(@PathVariable("id") Long id){
        return entryService.getSingle(id);
    }

    @PostMapping
    public Entry create(@RequestBody EntryDTO entryDTO){
        return entryService.create(entryDTO);
    }

    @PutMapping
    public Entry update(@RequestBody EntryDTO entryDTO){
        return entryService.update(entryDTO);
    }

    @PostMapping("/confirm/{id}")
    public EntryDTO confirmEntry(@PathVariable Long id){
        return entryService.confirmEntry(id);
    }
}
