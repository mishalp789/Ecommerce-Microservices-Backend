package com.mishalp789.product_service.service;

import com.mishalp789.product_service.dto.ProductRequest;
import com.mishalp789.product_service.dto.ProductResponse;
import com.mishalp789.product_service.entity.Product;
import com.mishalp789.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service 
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        Product savedProduct =
                productRepository.save(product);

        return mapToResponse(savedProduct);

    }

    public ProductResponse getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found with id: " + id
                        ));

        return mapToResponse(product);
    }

    private ProductResponse mapToResponse(Product product) {

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
    
}
