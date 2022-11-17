package com.academy.assetsproject.services;

import com.academy.assetsproject.enums.CategoryType;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Products> findAllProducts(Pageable pageable) throws RecordNotFoundException;
    Page<Products>findByCategory(CategoryType categoryType, Pageable pageable) throws RecordNotFoundException;
    Optional<Products> findByProductById(Long id)throws RecordNotFoundException;
    Products saveProducts(Products products);
    Products updateProducts (Products updateProducts, Long id)throws RecordNotFoundException;
    void deleteProducts(Long id)throws RecordNotFoundException;


}
