package com.academy.assetsproject.services;

import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Page<Products> findAllProducts(Pageable pageable);
//    Page<Products> findByCategory(Pageable pageable, String category);
    Products saveProducts(Products products);
    List<Products> findByProductById(Long id)throws RecordNotFoundException;
    Products updateProducts (Products updateProducts, Long id)throws RecordNotFoundException;
    void deleteProducts(Long id)throws RecordNotFoundException;

}
