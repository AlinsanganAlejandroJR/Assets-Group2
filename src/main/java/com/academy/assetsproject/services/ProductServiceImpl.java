package com.academy.assetsproject.services;

import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repo;

    @Override
    public Page<Products> findAllProducts(Pageable pageable) {
        return null;
    }

    @Override
    public Products saveProducts(Products products) {
        return repo.save(products);
    }

    @Override
    public Products findByProductById(Long id) throws RecordNotFoundException {
        return null;
    }

    @Override
    public Products updateProducts(Products updateProducts, Long id) throws RecordNotFoundException {
        return null;
    }

    @Override
    public void deleteProducts(Long id, Pageable pageable) throws RecordNotFoundException {

    }
}
