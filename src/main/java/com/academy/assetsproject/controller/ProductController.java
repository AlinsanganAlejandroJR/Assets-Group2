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

    public static final String ROLE_ADMIN = UserType.Constants.ADMIN_VALUE;
    public static final String ROLE_USER = UserType.Constants.USER_VALUE;

    @GetMapping
    @Secured(ROLE_USER)
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
    @Secured("ROLE_ADMIN")
    public Products saveProduct(@RequestBody Products products){
        return productService.saveProducts(products);
    }

    @PutMapping("/{Id}")
    @Secured("ROLE_ADMIN")
    private Products updateProduct(@RequestBody Products products, @PathVariable Long Id) throws RecordNotFoundException {
        return productService.updateProducts(products, Id);
    }
    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public void deleteProducts(@PathVariable Long id)throws RecordNotFoundException{
        productService.deleteProducts(id);
    }
}
