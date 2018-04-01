package com.shio.admin.service;

import com.shio.admin.DTO.EntryDTO;
import com.shio.admin.domain.Entry;
import com.shio.admin.mappers.EntryMapper;
import com.shio.admin.persistence.EntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EntryService {

    private EntryRepository entryRepository;
    private EntryMapper entryMapper;

    public List<EntryDTO> getAll(){
        return entryRepository.findAll()
                .stream()
                .map(e -> entryMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    public EntryDTO getSingle(Long id){
        return entryMapper.toDTO(entryRepository.findById(id).get());
    }

    public Entry create(EntryDTO entryDTO){
        return entryRepository.save(entryMapper.toEntity(entryDTO));
    }

    public Entry update(EntryDTO entryDTO){
        return entryRepository.save(entryMapper.toEntity(entryDTO));
    }

    public EntryDTO confirmEntry(Long id){
        Entry entry = entryRepository.findById(id).get();
        entry.setConfirmed(1);
        entryRepository.save(entry);
        return entryMapper.toDTO(entry);
    }

}
