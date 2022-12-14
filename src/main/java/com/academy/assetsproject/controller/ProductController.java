package com.academy.assetsproject.controller;

import com.academy.assetsproject.enums.CategoryType;
import com.academy.assetsproject.enums.UserType;
import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Products>> findAllProducts(Pageable pageable) throws RecordNotFoundException{
        Page<Products> products = productService.findAllProducts(pageable);
        return new ResponseEntity<Page<Products>>(products, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Products>> findProductById(@PathVariable Long id)throws RecordNotFoundException {
        Optional<Products> products = productService.findByProductById(id);
        return new ResponseEntity<Optional<Products>>(products, HttpStatus.OK);
    }
    @GetMapping("/category/{categoryType}")
    public ResponseEntity<Page<Products>> findByCategory(@PathVariable CategoryType categoryType, Pageable pageable) throws RecordNotFoundException {
        Page<Products> products = productService.findByCategory(categoryType, pageable);
        return new ResponseEntity<Page<Products>>(products, HttpStatus.OK);
    }
    @PostMapping
    public Products saveProduct(@RequestBody Products products){
        return productService.saveProducts(products);
    }

    @PutMapping("/{id}")
    private Products updateProduct(@RequestBody Products products, @PathVariable Long id) throws RecordNotFoundException {
        return productService.updateProducts(products, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducts(@PathVariable Long id)throws RecordNotFoundException{
        productService.deleteProducts(id);
        return new ResponseEntity<>("The Product has been Deleted",HttpStatus.OK);
    }
}
