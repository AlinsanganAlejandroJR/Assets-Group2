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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repo;

    @Override
    public Page<Products> findAllProducts(Pageable pageable)throws RecordNotFoundException{
        Page<Products> productsOptional = repo.findAll(pageable);
        if (productsOptional.isEmpty()){
            throw new RecordNotFoundException("No Records");
        }
        return productsOptional;
    }

    @Override
    public Page<Products> findByCategory(CategoryType categoryType, Pageable pageable) throws RecordNotFoundException {
        List<Products> items = repo.findAll(pageable)
                .stream()
                .filter(products -> products.getType().equals(categoryType)).toList();
        return new PageImpl<>(items);
        //return repo.findByType(types, pageable);
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
    public Products saveProducts(Products products) {
        return repo.save(products);
    }

    @Override
    public Products updateProducts(Products updateProducts, Long id) throws RecordNotFoundException {
        Optional<Products> productsOptional = repo.findById(id);
        if(productsOptional.isPresent()){
            Products entity = new Products();
            entity.setId(updateProducts.getId());
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
    public void deleteProducts(Long id) throws RecordNotFoundException {
        Optional<Products> products = repo.findById(id);
        if (products.isEmpty()) {
            repo.findById(id).stream().filter(products1 -> products1.getId() == id)
                    .collect(Collectors.toList());
        } else repo.delete(products.get());
    }
}
