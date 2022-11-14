package com.academy.assetsproject.Controller;

import com.academy.assetsproject.models.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductController {
    //TODo
    //TODO Autowired product service
    @GetMapping("{id}")
    public Products getProduct(@RequestParam Products products){
        System.out.println(products);
        return products;
    }
}
