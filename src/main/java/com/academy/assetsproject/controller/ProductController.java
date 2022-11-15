package com.academy.assetsproject.controller;

import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Products>> getAllProducts(Pageable pageable) throws RecordNotFoundException{
        Page<Products> products = productService.findAllProducts(pageable);
        return new ResponseEntity<Page<Products>>(products, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Products>> findProductById(@PathVariable Long id)throws RecordNotFoundException {
        List<Products> products = productService.findByProductById(id);
        return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
    }

    @PostMapping
    public Products saveProduct(@RequestBody Products products){
        return productService.saveProducts(products);
    }

    @PutMapping("/{Id}")
    private Products updateProduct(@RequestBody Products products, @PathVariable Long Id) throws RecordNotFoundException {
        return productService.updateProducts(products, Id);
    }

    @DeleteMapping("/{id}")
    public void deleteProducts(@PathVariable Long id)throws RecordNotFoundException{
        productService.deleteProducts(id);
    }


}
