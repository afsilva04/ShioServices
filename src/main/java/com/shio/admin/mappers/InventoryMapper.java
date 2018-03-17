package com.shio.admin.mappers;

import com.shio.admin.DTO.InventoryDTO;
import com.shio.admin.domain.Inventory;
import com.shio.admin.persistence.ProductRepository;
import com.shio.admin.persistence.SubsidiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class InventoryMapper {

    private ProductRepository productRepository;
    private SubsidiaryRepository subsidiaryRepository;

    public InventoryDTO toDTO(Inventory inventory){

        InventoryDTO inventoryDTO = new InventoryDTO();

        inventoryDTO.setId(inventory.getId());
        inventoryDTO.setQuantity(inventory.getQuantity());
        inventoryDTO.setProductId(inventory.getProduct().getId());
        inventoryDTO.setProductName(inventory.getProduct().getName());
        inventoryDTO.setSubsidiaryId(inventory.getSubsidiary().getId());
        inventoryDTO.setSubsidiaryName(inventory.getSubsidiary().getName());

        return inventoryDTO;

    }

    public Inventory toEntity(InventoryDTO inventoryDTO){

        Inventory inventory = new Inventory();

        inventory.setId(inventoryDTO.getId());
        inventory.setQuantity(inventoryDTO.getQuantity());
        inventory.setProduct(productRepository.findOne(inventoryDTO.getProductId()));
        inventory.setSubsidiary(subsidiaryRepository.findOne(inventoryDTO.getSubsidiaryId()));

        return inventory;

    }

}
