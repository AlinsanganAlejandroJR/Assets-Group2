package com.academy.assetsproject.services;

import com.academy.assetsproject.enums.CategoryType;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Products> findAllProducts(Pageable pageable) throws RecordNotFoundException;
    Page<Products>findByCategory(CategoryType categoryType, Pageable pageable) throws RecordNotFoundException;
    List<Products> findByProductById(Long id)throws RecordNotFoundException;
    Products saveProducts(Products products);
    Products updateProducts (Products updateProducts, Long id)throws RecordNotFoundException;
    void deleteProducts(Long id)throws RecordNotFoundException;


}
