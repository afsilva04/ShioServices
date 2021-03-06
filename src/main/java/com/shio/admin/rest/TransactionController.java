package com.shio.admin.rest;

import com.shio.admin.DTO.TransactionDTO;
import com.shio.admin.domain.Transaction;
import com.shio.admin.security.SecurityUtils;
import com.shio.admin.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;
    private HttpServletRequest httpServletRequest;

    @GetMapping
    public List<TransactionDTO> getAll(){
        return transactionService.getAll(SecurityUtils.getSubsidiaryFromToken(httpServletRequest));
    }

    @GetMapping("/{id}")
    public TransactionDTO getSingle(@PathVariable("id") Long id){
        return transactionService.getSingle(id);
    }

    @PostMapping
    public Transaction create(@RequestBody TransactionDTO transactionDTO){
        return transactionService.create(transactionDTO);
    }

    @PutMapping
    public Transaction update(@RequestBody TransactionDTO transactionDTO){
        return transactionService.update(transactionDTO);
    }

    @PostMapping("/coupon/{transaction_id}")
    public Transaction generateCoupons(@PathVariable("transaction_id") Long id){
        return transactionService.generateCoupons(id);
    }

    @PostMapping("/confirm/{transaction_id}")
    public Transaction confirm(@PathVariable("transaction_id") Long id){
        return transactionService.confirm(id);
    }

}
