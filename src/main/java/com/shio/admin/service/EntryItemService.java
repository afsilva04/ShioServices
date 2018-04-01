package com.shio.admin.service;

import com.shio.admin.DTO.EntryItemDTO;
import com.shio.admin.domain.EntryItem;
import com.shio.admin.mappers.EntryItemMapper;
import com.shio.admin.persistence.EntryItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EntryItemService {

    private EntryItemRepository entryItemRepository;
    private EntryItemMapper entryItemMapper;

    public List<EntryItemDTO> getAll(){
        return entryItemRepository.findAll()
                .stream()
                .map(i -> entryItemMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    public List<EntryItemDTO> getAllByEntry(Long entryId){
        return entryItemRepository.findAllByEntryId(entryId)
                .stream()
                .map(a -> entryItemMapper.toDTO(a))
                .collect(Collectors.toList());
    }

    public EntryItemDTO getSingle(Long id){
        return entryItemMapper.toDTO(entryItemRepository.findById(id).get());
    }

    public List<EntryItem> getAllByEntryAndId(Long entryId, Long id){
        return entryItemRepository.findAllByEntryIdAndId(entryId, id);
    }

    public EntryItem create(EntryItemDTO transactionItem){
        return entryItemRepository.save(entryItemMapper.toEntity(transactionItem));
    }

    public EntryItem update(EntryItemDTO transactionItem){
        return entryItemRepository.save(entryItemMapper.toEntity(transactionItem));
    }

    public void delete(Long id){
        entryItemRepository.deleteById(id);
    }

}
