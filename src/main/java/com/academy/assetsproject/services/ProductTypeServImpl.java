package com.academy.assetsproject.services;

import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.ProductTypes;
import com.academy.assetsproject.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServImpl implements ProductTypeService{
    @Autowired
    private ProductTypeRepository repo;

    @Override
    public ProductTypes saveProductType(ProductTypes productTypes) {
        return repo.save(productTypes);
    }

    @Override
    public Page<ProductTypes> findByProductTypes(ProductTypes productTypes, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductTypes> findAllProductTypes(Pageable pageable) {
        return null;
    }

    @Override
    public ProductTypes findProductTypesById(Long id) throws RecordNotFoundException {
        return null;
    }

    @Override
    public ProductTypes updateProductTypes(ProductTypes productType, Long id) throws RecordNotFoundException {
        return null;
    }

    @Override
    public void deleteProductTypes(Long id, Pageable pageable) throws RecordNotFoundException {

    }
}
