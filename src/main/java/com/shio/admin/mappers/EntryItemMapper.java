package com.shio.admin.mappers;

import com.shio.admin.DTO.EntryItemDTO;
import com.shio.admin.domain.EntryItem;
import com.shio.admin.persistence.EntryRepository;
import com.shio.admin.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntryItemMapper {

    private ProductRepository productRepository;
    private EntryRepository entryRepository;

    public EntryItemDTO toDTO(EntryItem entryItem){

        EntryItemDTO entryItemDTO = new EntryItemDTO();

        entryItemDTO.setId(entryItem.getId());
        entryItemDTO.setQuantity(entryItem.getQuantity());
        entryItemDTO.setProductId(entryItem.getProduct().getId());
        entryItemDTO.setProductName(entryItem.getProduct().getName());
        entryItemDTO.setEntryId(entryItem.getEntry().getId());

        return entryItemDTO;

    }

    public EntryItem toEntity(EntryItemDTO entryItemDTO){

        EntryItem entryItem = new EntryItem();

        entryItem.setId(entryItemDTO.getId());
        entryItem.setQuantity(entryItemDTO.getQuantity());

        if(entryItemDTO.getProductId() != null && entryItemDTO.getProductId() != 0)
            entryItem.setProduct(productRepository.findById(entryItemDTO.getProductId()).get());
        else
            entryItem.setProduct(null);

        if(entryItemDTO.getEntryId() != null && entryItemDTO.getEntryId() != 0)
            entryItem.setEntry(entryRepository.findById(entryItemDTO.getEntryId()).get());
        else
            entryItem.setEntry(null);

        return entryItem;

    }

}
