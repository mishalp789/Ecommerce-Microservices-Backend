package com.mishalp789.product_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products") 
public class ProductController {

    @GetMapping("/health")
    public String getProducts() {
        return "Product Service is running";
    }
    
}
