package com.spring.springSecurity.controller;

import com.spring.springSecurity.entity.Product;
import com.spring.springSecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String getMsg(){
        return "Welcome to Spring security...";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public Product getProductById(@PathVariable int id){
        return service.getProduct(id);
    }
}
