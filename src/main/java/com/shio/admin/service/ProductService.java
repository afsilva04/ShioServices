package com.shio.admin.service;

import com.shio.admin.domain.Product;
import com.shio.admin.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public List<Product> getServices(String searchTxt){
        if(searchTxt.isEmpty()){
            return productRepository.findAll();
        } else {
            return productRepository.findByNameContainingIgnoreCase(searchTxt);
        }
    }

    public Product getSingle(Long id){
        return productRepository.findById(id).get();
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product update(Product product){
        return productRepository.save(product);
    }

}
