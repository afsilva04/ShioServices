package com.shio.admin.rest;

import com.shio.admin.DTO.InventoryDTO;
import com.shio.admin.domain.Inventory;
import com.shio.admin.security.SecurityUtils;
import com.shio.admin.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryService inventoryService;
    private HttpServletRequest httpServletRequest;

    @GetMapping("/{id}")
    public InventoryDTO getSingle(@PathVariable("id") Long id){
        return inventoryService.getSingle(id);
    }

    @GetMapping
    public List<InventoryDTO> getAll(){
        return inventoryService.getAll(SecurityUtils.getSubsidiaryFromToken(httpServletRequest));
    }

    @GetMapping("/subsidiary/{id}")
    public List<InventoryDTO> getAllBySubsidiary(@PathVariable("id") Long id){
        return inventoryService.getAllBySubsidiary(id);
    }

    @PostMapping("/add/{product}/{subsidiary}/{quantity}")
    public Inventory add(@PathVariable("product") Long product,
                         @PathVariable("subsidiary") Long subsidiary,
                         @PathVariable("quantity") int quantity){
        return inventoryService.add(product, subsidiary, quantity);
    }

    @PostMapping("/substract/{product}/{subsidiary}/{quantity}")
    public Inventory substract(@PathVariable("product") Long product,
                               @PathVariable("subsidiary") Long subsidiary,
                               @PathVariable("quantity") int quantity){
        return inventoryService.substract(product, subsidiary, quantity);
    }

    @PostMapping("/substract/{id_transaction}")
    public void substractInventoryByTransaction(@PathVariable("id_transaction") Long id){
        inventoryService.substractInventoryByTransaction(id);
    }

    @PostMapping("/add/{id_transaction}")
    public void addInventoryByTransaction(@PathVariable("id_transaction") Long id){
        inventoryService.addInventoryByTransaction(id);
    }

    @PostMapping("/add-by-entry/{id_entry}")
    public void addInventoryByEntry(@PathVariable("id_entry") Long id){
        inventoryService.addInventoryByEntry(id);
    }

    @PostMapping
    public Inventory save(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.save(inventoryDTO);
    }

}
