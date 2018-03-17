package com.shio.admin.service;

import com.shio.admin.DTO.InventoryDTO;
import com.shio.admin.domain.Inventory;
import com.shio.admin.domain.Transaction;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.mappers.InventoryMapper;
import com.shio.admin.persistence.InventoryRepository;
import com.shio.admin.persistence.TransactionItemRepository;
import com.shio.admin.persistence.TransactionRepository;
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

    public List<InventoryDTO> getAll(){
        return inventoryRepository.findAll()
                .stream()
                .map(i -> inventoryMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    public InventoryDTO getSingle(Long id){
        return inventoryMapper.toDTO(inventoryRepository.findOne(id));
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
        Transaction transaction = transactionRepository.findOne(id);
        List<TransactionItem> transactionItems = transactionItemRepository.findAllByTransactionId(id);

        for (TransactionItem item : transactionItems) {
            if(item.getProduct() != null)
                substract(item.getProduct().getId(), transaction.getSubsidiary().getId(), item.getQuantity());
        }
    }

    public void addInventoryByTransaction(Long id){
        Transaction transaction = transactionRepository.findOne(id);
        List<TransactionItem> transactionItems = transactionItemRepository.findAllByTransactionId(id);

        for (TransactionItem item : transactionItems) {
            if(item.getProduct() != null)
                add(item.getProduct().getId(), transaction.getSubsidiary().getId(), item.getQuantity());
        }
    }

}
