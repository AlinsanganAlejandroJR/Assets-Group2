package com.academy.assetsproject.services;

import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = Logger.getLogger("com.api.jar");
    @Autowired
    private ProductRepository repo;

    @Override
    public Page<Products> findAllProducts(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Products saveProducts(Products products) {
        return repo.save(products);
    }

    @Override
    public List<Products> findByProductById(Long id) throws RecordNotFoundException {
        Optional<Products> productsOptional = repo.findById(id);
        if (productsOptional.isPresent()) {
            return repo.findById(id).stream().filter(products -> products.getId() == id)
                    .collect(Collectors.toList());
        } else throw new RecordNotFoundException("RECORD NOT FOUND");
    }

    @Override
    public Products updateProducts(Products updateProducts, Long id) throws RecordNotFoundException {
       return null;
    }
    @Override
    public void deleteProducts(Long id) throws RecordNotFoundException {
        Optional<Products> products = repo.findById(id);
        if (products.isEmpty()) {
            repo.findById(id).stream().filter(products1 -> products1.getId() == id)
                    .collect(Collectors.toList());
        } else repo.delete(products.get());
    }
}