package com.academy.assetsproject.controller;

import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.repository.ProductRepository;
import com.academy.assetsproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Products saveProduct(@RequestBody Products products){
        return productService.saveProducts(products);
    }
    @GetMapping
    public ResponseEntity<Page<Products>> getAllProducts(Pageable pageable){
        Page<Products> products = productService.findAllProducts(pageable);
        return new ResponseEntity<Page<Products>>(products, HttpStatus.OK);
    }
     @GetMapping("/{id}")
    public List<Products> findProductById(@PathVariable Long id)throws RecordNotFoundException {
        return productService.findByProductById(id);
     }
    @DeleteMapping("/{id}")
    public void deleteProducts(@PathVariable Long id)throws RecordNotFoundException{
        productService.deleteProducts(id);
    }
}
