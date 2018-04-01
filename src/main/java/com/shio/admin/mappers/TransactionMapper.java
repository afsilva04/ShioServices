package com.shio.admin.mappers;

import com.shio.admin.DTO.TransactionDTO;
import com.shio.admin.domain.Transaction;
import com.shio.admin.persistence.ClientRepository;
import com.shio.admin.persistence.SubsidiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransactionMapper {

    private ClientRepository clientRepository;
    private SubsidiaryRepository subsidiaryRepository;

    public TransactionDTO toDTO(Transaction transaction){

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setId(transaction.getId());
        transactionDTO.setDate(transaction.getDate());
        transactionDTO.setInvoice(transaction.getInvoice());
        transactionDTO.setInvoicePdf(transaction.getInvoicepdf());
        transactionDTO.setCanceled(transaction.getCanceled());
        transactionDTO.setProcessed(transaction.getProcessed());
        transactionDTO.setReasonId(transaction.getReason());
        transactionDTO.setClientId(transaction.getClient().getId());
        transactionDTO.setClientName(transaction.getClient().getName());
        transactionDTO.setSubsidiaryId(transaction.getSubsidiary().getId());
        transactionDTO.setSubsidiaryName(transaction.getSubsidiary().getName());

        return transactionDTO;

    }

    public Transaction toEntity(TransactionDTO transactionDTO){

        Transaction transaction = new Transaction();

        transaction.setId(transactionDTO.getId());
        transaction.setDate(transactionDTO.getDate());
        transaction.setInvoice(transactionDTO.getInvoice());
        transaction.setInvoicepdf(transactionDTO.getInvoicePdf());
        transaction.setCanceled(transactionDTO.getCanceled());
        transaction.setProcessed(transactionDTO.getProcessed());
        transaction.setReason(transactionDTO.getReasonId());
        transaction.setClient(clientRepository.findById(transactionDTO.getClientId()).get());
        transaction.setSubsidiary(subsidiaryRepository.findById(transactionDTO.getSubsidiaryId()).get());

        return transaction;

    }

}
