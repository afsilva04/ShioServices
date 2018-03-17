package com.shio.admin.mappers;

import com.shio.admin.DTO.EntryDTO;
import com.shio.admin.domain.Entry;
import com.shio.admin.domain.Subsidiary;
import com.shio.admin.persistence.SubsidiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntryMapper {

    private SubsidiaryRepository subsidiaryRepository;

    public EntryDTO toDTO(Entry entry){

        EntryDTO entryDTO = new EntryDTO();

        entryDTO.setId(entry.getId());
        entryDTO.setDate(entry.getDate());
        entryDTO.setConfirmed(entry.getConfirmed());

        switch (entryDTO.getConfirmed()){
            case 0:
                entryDTO.setConfirmedName("Pendiente");
                break;
            case 1:
                entryDTO.setConfirmedName("Confirmada");
                break;
            default:
                break;
        }

        if(entry.getSubsidiary() != null) {
            entryDTO.setSubsidiaryId(entry.getSubsidiary().getId());
            entryDTO.setSubsidiaryName(entry.getSubsidiary().getName());
        }

        return entryDTO;

    }

    public Entry toEntity(EntryDTO entryDTO){

        Entry entry = new Entry();

        entry.setId(entryDTO.getId());
        entry.setDate(entryDTO.getDate());
        entry.setConfirmed(entryDTO.getConfirmed());

        if (entryDTO.getSubsidiaryId() != null && entryDTO.getSubsidiaryId() != 0)
            entry.setSubsidiary(subsidiaryRepository.findOne(entryDTO.getSubsidiaryId()));
        else
            entry.setSubsidiary(null);

        return entry;

    }

}
