package com.shio.admin.rest;

import com.shio.admin.DTO.EntryItemDTO;
import com.shio.admin.domain.EntryItem;
import com.shio.admin.service.EntryItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/entry-items")
public class EntryItemController {

    private EntryItemService entryItemService;

    @GetMapping("/{entry_id}")
    public List<EntryItemDTO> getAll(@PathVariable("entry_id") Long entryId){
        return entryItemService.getAllByEntry(entryId);
    }

    @GetMapping("/{entry_id}/{id}")
    public List<EntryItem> getSingle(@PathVariable("entry_id") Long entryId,
                                     @PathVariable("id") Long id){
        return entryItemService.getAllByEntryAndId(entryId, id);
    }

    @PostMapping
    public EntryItem create(@RequestBody EntryItemDTO entryItemDTO){
        return entryItemService.create(entryItemDTO);
    }

    @PutMapping
    public EntryItem update(@RequestBody EntryItemDTO entryItemDTO){
        return entryItemService.update(entryItemDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        entryItemService.delete(id);
    }

}
