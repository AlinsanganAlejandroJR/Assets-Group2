package com.academy.assetsproject.services;

import com.academy.assetsproject.enums.CategoryType;
import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repo;

    @Override
    public Page<Products> findAllProducts(Pageable pageable) throws RecordNotFoundException {
        return repo.findAll(pageable);
    }

    @Override
    public Page<Products> findByCategory(CategoryType categoryType, Pageable product) throws RecordNotFoundException {
        List<Products> items = repo.findAll(product)
                .stream()
                .filter(products -> products.getType().equals(categoryType)).toList();
        return new PageImpl<>(items);
    }

    @Override
    public Optional<Products> findByProductById (Long id) throws RecordNotFoundException {
        Optional<Products> productsOptional = repo.findById(id);
            if (productsOptional.isPresent()) {
                return repo.findById(id).filter(products -> products.getId() == id);

            } else throw new RecordNotFoundException("RECORD NOT FOUND");
    }
    @Override
    public Products saveProducts (Products products){
        return repo.save(products);
    }

    @Override
    public Products updateProducts(Products updateProducts, Long id) throws RecordNotFoundException{
        return repo.findById(id).map(products -> {
            products.setName(updateProducts.getName());
            products.setType(updateProducts.getType());
            products.setPrice(updateProducts.getPrice());
            //products.setDateOfPurchase(updateProducts.getDateOfPurchase());
            return repo.save(products);
        }).orElseThrow(() -> new RecordNotFoundException("NOT FOUND"));
    }
    @Override
    public void deleteProducts (Long id) throws RecordNotFoundException {
        Optional<Products> products = repo.findById(id);
        if (products.isEmpty()) {
            repo.findById(id).stream().filter(products1 -> products1.getId() == id);
        } else repo.delete(products.get());
    }
}

