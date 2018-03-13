package com.shio.admin.service;

import com.shio.admin.DTO.TransactionDTO;
import com.shio.admin.domain.Transaction;
import com.shio.admin.mappers.TransactionMapper;
import com.shio.admin.persistence.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;

    public List<TransactionDTO> getAll(){
        return transactionRepository.findAll()
                .stream()
                .map(t -> transactionMapper.toDTO(t))
                .collect(Collectors.toList());
    }

    public TransactionDTO getSingle(Long id){
        return transactionMapper.toDTO(transactionRepository.findOne(id));
    }

    public Transaction create(TransactionDTO transaction){
        return transactionRepository.save(transactionMapper.toEntity(transaction));
    }

    public Transaction update(TransactionDTO transaction){
        return transactionRepository.save(transactionMapper.toEntity(transaction));
    }

}
