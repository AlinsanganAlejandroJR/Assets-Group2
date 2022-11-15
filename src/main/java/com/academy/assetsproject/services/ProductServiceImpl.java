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
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

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
        return repo.findById(id).stream().filter(products -> products.getId() == id).collect(Collectors.toList());
    }

    @Override
    public Products updateProducts(Products updateProducts, Long id) throws RecordNotFoundException {

        Optional<Products> products = repo.findById(id);
        if(products.isPresent()){
            Products entity = new Products();
            entity.setName(updateProducts.getName());
            entity.setType(updateProducts.getType());
            entity.setPrice(updateProducts.getPrice());
            entity.setDateOfPurchase(updateProducts.getDateOfPurchase());
            return repo.save(entity);

        }else{
            throw new RecordNotFoundException("Product not found");
        }
    }

    @Override
    public void deleteProducts(Long id, Pageable pageable) throws RecordNotFoundException {

    }
}
