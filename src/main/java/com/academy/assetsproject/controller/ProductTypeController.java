package com.academy.assetsproject.controller;

import com.academy.assetsproject.models.ProductTypes;
import com.academy.assetsproject.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product_type")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping
    public ProductTypes saveProductType(@RequestBody ProductTypes productTypes){
        return productTypeService.saveProductType(productTypes);
    }
}
