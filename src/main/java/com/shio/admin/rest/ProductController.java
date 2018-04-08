package com.shio.admin.rest;

import com.shio.admin.domain.Product;
import com.shio.admin.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/search")
    public List<Product> getAll(@RequestParam(value = "search_txt", required = false) String searchTxt) {
        return productService.getServices(searchTxt);
    }

    @GetMapping("/{id}")
    public Product getSingle(@PathVariable("id") Long id){
        return productService.getSingle(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

}
