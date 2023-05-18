package com.spring.springSecurity.service;

import com.spring.springSecurity.entity.Product;
import com.spring.springSecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

        @Autowired
        private ProductRepository productRepository;
        public List<Product> getAllProducts(){
            return productRepository.findAll();
        }

        public Product getProduct(Integer id){
            Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("No Product Avilable..."));
            return product;
        }
}
