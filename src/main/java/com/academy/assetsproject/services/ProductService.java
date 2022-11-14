package com.academy.assetsproject.services;

import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
 Page<Products> findAllProducts(Pageable pageable);
 Products saveProducts(Products products);
 Products findByProductById(Long id)throws RecordNotFoundException;
 Products updateProducts (Products updateProducts, Long id)throws RecordNotFoundException;
 void deleteProducts(Long id, Pageable pageable)throws RecordNotFoundException;

}
