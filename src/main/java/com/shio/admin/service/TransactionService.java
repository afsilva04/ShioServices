package com.shio.admin.service;

import com.shio.admin.DTO.TransactionDTO;
import com.shio.admin.DTO.TransactionItemDTO;
import com.shio.admin.domain.Transaction;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.mappers.TransactionItemMapper;
import com.shio.admin.mappers.TransactionMapper;
import com.shio.admin.persistence.TransactionItemRepository;
import com.shio.admin.persistence.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;
    private TransactionItemRepository transactionItemRepository;
    private TransactionItemMapper transactionItemMapper;

    public List<TransactionDTO> getAll(){
        return transactionRepository.findAll()
                .stream()
                .map(t -> transactionMapper.toDTO(t))
                .collect(Collectors.toList());
    }

    public TransactionDTO getSingle(Long id){
        return transactionMapper.toDTO(transactionRepository.findById(id).get());
    }

    public Transaction create(TransactionDTO transaction){
        return transactionRepository.save(transactionMapper.toEntity(transaction));
    }

    public Transaction update(TransactionDTO transaction){
        return transactionRepository.save(transactionMapper.toEntity(transaction));
    }

    public Transaction generateCoupons(Long transactionId){
        Transaction transaction = transactionRepository.findById(transactionId).get();
        List<TransactionItemDTO> transactionItemDTOS =
                transactionItemRepository.findAllByTransactionId(transactionId)
                .stream()
                .map(i -> transactionItemMapper.toDTO(i))
                .collect(Collectors.toList());

        //int index = 0;
        for (TransactionItemDTO item : transactionItemDTOS) {
            if(item.getAnticipated() != null && item.getAnticipated()) {
                //index++;
                Long datetime = System.currentTimeMillis();
                item.setCoupon(transaction.getSubsidiary().getName().substring(0, 2).toUpperCase()
                        //+ index
                        + transaction.getId()
                        + "T"
                        + item.getId()
                        + "N"
                        + datetime.toString());
                transactionItemRepository.save(transactionItemMapper.toEntity(item));
            }
        }

        return transaction;
    }

    public Transaction confirm(Long id){
        Transaction transaction = transactionRepository.findById(id).get();
        transaction.setInvoice("1");
        return transactionRepository.save(transaction);
    }

}
