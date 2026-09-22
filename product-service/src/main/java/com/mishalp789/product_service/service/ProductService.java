package com.mishalp789.product_service.service;

import com.mishalp789.product_service.entity.Product;
import com.mishalp789.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service 
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Product not found"));
    }
    
}
