package com.academy.assetsproject.controller;

import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.repository.ProductRepository;
import com.academy.assetsproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Products saveProduct(@RequestBody Products products){
        return productService.saveProducts(products);
    }

    @PutMapping("/{Id}")
    private Products updateProduct(@RequestBody Products products, @PathVariable Long Id) throws RecordNotFoundException {
        return productService.updateProducts(products, Id);
    }


}
