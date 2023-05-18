package com.lcwd.mvc.SpringMvcProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class Product {

    @GetMapping("/productData")
    public String getProduct(@RequestParam("pname") String name,@RequestParam("pqty") int qty,@RequestParam("rating") int rating)
    {
        System.out.println("Product Name : "+name);
        System.out.println("Product Qty : "+qty);
        System.out.println("Product rating : "+rating);
        return "request accepted..";
    }

    @RequestMapping("/getProductDataa/{pid}/{pname}/{pqty}/{prating}")
    public String getProductData(
            @PathVariable("pid") int id,
            @PathVariable("pname") String pname,
            @PathVariable int pqty,
            @PathVariable int prating
    )
    {
        System.out.println("Product Id : "+id);
        System.out.println("Product Name : "+pname);
        System.out.println("Product Qty : "+pqty);
        System.out.println("Product rating : "+prating);
        return "Path variable successfully running...";
    }

    Logger logger = LoggerFactory.getLogger(Product.class);

    @RequestMapping("/student/{id}/{name}/{standard}")
    public String studentData(@PathVariable("id") int id,@PathVariable String name,@PathVariable String standard)
    {
        logger.error("Student id {}",id);
        logger.warn("Student name {}" , name);
        logger.info("Student Standard {}",standard);

        return "using logger result shown....";
    }

}
