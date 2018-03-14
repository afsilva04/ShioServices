package com.shio.admin.rest;

import com.shio.admin.DTO.InvoiceDTO;
import com.shio.admin.DTO.InvoiceData;
import com.shio.admin.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private InvoiceService invoiceService;

    @GetMapping("{idTransaction}")
    public InvoiceDTO getInvoiceInfo(@PathVariable("idTransaction") Long idTransaction){
        return invoiceService.getInvoiceData(idTransaction);
    }

    @PostMapping
    public String satInvoice(@RequestBody InvoiceData invoiceData){
        return invoiceService.createInvoice(invoiceData);
    }

}
