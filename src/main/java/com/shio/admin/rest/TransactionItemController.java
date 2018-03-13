package com.shio.admin.rest;

import com.shio.admin.DTO.TransactionItemDTO;
import com.shio.admin.domain.TransactionItem;
import com.shio.admin.service.TransactionItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/transaction-items")
public class TransactionItemController {

    private TransactionItemService transactionItemService;

    @GetMapping("/{transaction_id}")
    public List<TransactionItemDTO> getAll(@PathVariable("transaction_id") Long transactionId){
        return transactionItemService.getAllByTransaction(transactionId);
    }

    @GetMapping("/{transaction_id}/{id}")
    public List<TransactionItem> getSingle(@PathVariable("transaction_id") Long transactionId,
                                        @PathVariable("id") Long id){
        return transactionItemService.getAllByTransactionAndId(transactionId, id);
    }

    @PostMapping
    public TransactionItem create(@RequestBody TransactionItemDTO transactionItemDTO){
        return transactionItemService.create(transactionItemDTO);
    }

    @PutMapping
    public TransactionItem update(@RequestBody TransactionItemDTO transactionItemDTO){
        return transactionItemService.update(transactionItemDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        transactionItemService.delete(id);
    }


}
