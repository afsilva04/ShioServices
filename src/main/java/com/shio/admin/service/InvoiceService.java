package com.shio.admin.service;

import com.shio.admin.DTO.InvoiceDTO;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.mappers.TransactionItemMapper;
import com.shio.admin.mappers.TransactionMapper;
import com.shio.admin.persistence.TransactionItemRepository;
import com.shio.admin.persistence.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InvoiceService {

    private TransactionRepository transactionRepository;
    private TransactionItemRepository transactionItemRepository;
    private TransactionMapper transactionMapper;
    private TransactionItemMapper transactionItemMapper;

    public InvoiceDTO getInvoiceData(Long id){

        InvoiceDTO invoiceDTO = new InvoiceDTO();

        invoiceDTO.setTransaction(transactionMapper.toDTO(transactionRepository.findOne(id)));

        invoiceDTO.setTransactionItems(transactionItemRepository.findAllByTransactionId(id)
                .stream()
                .map(i -> transactionItemMapper.toDTO(i))
                .collect(Collectors.toList()));

        invoiceDTO.setSubtotal(invoiceDTO.getTransactionItems()
                .stream()
                .map(s -> s.getPrice().multiply((new BigDecimal(s.getQuantity()))).add(s.getAditional()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_UP));

        invoiceDTO.setTax(invoiceDTO.getSubtotal()
                .multiply(new BigDecimal(0.16))
                .setScale(2, BigDecimal.ROUND_UP));

        invoiceDTO.setTotal(invoiceDTO.getSubtotal()
                .add(invoiceDTO.getTax())
                .setScale(2, BigDecimal.ROUND_UP));

        return invoiceDTO;
    }

}
