package com.shio.admin.service;

import com.shio.admin.DTO.InventoryDTO;
import com.shio.admin.domain.*;
import com.shio.admin.mappers.InventoryMapper;
import com.shio.admin.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;
    private InventoryMapper inventoryMapper;
    private TransactionRepository transactionRepository;
    private TransactionItemRepository transactionItemRepository;
    private EntryRepository entryRepository;
    private EntryItemRepository entryItemRepository;

    public List<InventoryDTO> getAll(){
        return inventoryRepository.findAll()
                .stream()
                .map(i -> inventoryMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    public InventoryDTO getSingle(Long id){
        return inventoryMapper.toDTO(inventoryRepository.findById(id).get());
    }

    public List<InventoryDTO> getAllBySubsidiary(Long subsidiaryId){
        return inventoryRepository.findAllBySubsidiaryId(subsidiaryId)
                .stream()
                .map(i -> inventoryMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    public Inventory save(InventoryDTO inventoryDTO){
        return inventoryRepository.save(inventoryMapper.toEntity(inventoryDTO));
    }

    public Inventory add(Long idProduct, Long idSubsidiary, int quantity){
        Inventory inventory = inventoryRepository.findByProductIdAndSubsidiaryId(idProduct, idSubsidiary);
        inventory.setQuantity(inventory.getQuantity() + quantity);
        return inventoryRepository.save(inventory);
    }

    public Inventory substract(Long idProduct, Long idSubsidiary, int quantity){
        Inventory inventory = inventoryRepository.findByProductIdAndSubsidiaryId(idProduct, idSubsidiary);
        inventory.setQuantity(inventory.getQuantity() - quantity);
        return inventoryRepository.save(inventory);
    }

    public void substractInventoryByTransaction(Long id){
        Transaction transaction = transactionRepository.findById(id).get();
        List<TransactionItem> transactionItems = transactionItemRepository.findAllByTransactionId(id);

        for (TransactionItem item : transactionItems) {
            if(item.getProduct() != null) // && (item.getAnticipated() == null || !item.getAnticipated()))
                substract(item.getProduct().getId(), transaction.getSubsidiary().getId(), item.getQuantity());
        }
    }

    public void addInventoryByTransaction(Long id){
        Transaction transaction = transactionRepository.findById(id).get();
        List<TransactionItem> transactionItems = transactionItemRepository.findAllByTransactionId(id);

        for (TransactionItem item : transactionItems) {
            if(item.getProduct() != null)
                add(item.getProduct().getId(), transaction.getSubsidiary().getId(), item.getQuantity());
        }
    }

    public void addInventoryByEntry(Long id){
        Entry entry = entryRepository.findById(id).get();
        List<EntryItem> entryItems = entryItemRepository.findAllByEntryId(id);

        for (EntryItem item: entryItems){
            if(item.getProduct() != null)
                add(item.getProduct().getId(), entry.getSubsidiary().getId(), item.getQuantity());
        }
    }

    public void substractInventoryByEntry(Long id){
        Entry entry = entryRepository.findById(id).get();
        List<EntryItem> entryItems = entryItemRepository.findAllByEntryId(id);

        for (EntryItem item: entryItems){
            if(item.getProduct() != null)
                substract(item.getProduct().getId(), entry.getSubsidiary().getId(), item.getQuantity());
        }
    }

}
