package com.shio.admin.service;

import com.shio.admin.DTO.TransactionItemDTO;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.mappers.TransactionItemMapper;
import com.shio.admin.persistence.TransactionItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransactionItemService {

    private TransactionItemRepository transactionItemRepository;
    private TransactionItemMapper transactionItemMapper;

    public List<TransactionItemDTO> getAll(){
        return transactionItemRepository.findAll()
                .stream()
                .map(i -> transactionItemMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    public List<TransactionItemDTO> getAllByTransaction(Long transactionId){
        return transactionItemRepository.findAllByTransactionId(transactionId)
                .stream()
                .map(a -> transactionItemMapper.toDTO(a))
                .collect(Collectors.toList());
    }

    public TransactionItemDTO getSingle(Long id){
        return transactionItemMapper.toDTO(transactionItemRepository.findOne(id));
    }

    public List<TransactionItem> getAllByTransactionAndId(Long transactionId, Long id){
        return transactionItemRepository.findAllByTransactionIdAndId(transactionId, id);
    }

    public TransactionItem create(TransactionItemDTO transactionItem){
        return transactionItemRepository.save(transactionItemMapper.toEntity(transactionItem));
    }

    public TransactionItem update(TransactionItemDTO transactionItem){
        return transactionItemRepository.save(transactionItemMapper.toEntity(transactionItem));
    }

    public void delete(Long id){
        transactionItemRepository.delete(id);
    }

}
