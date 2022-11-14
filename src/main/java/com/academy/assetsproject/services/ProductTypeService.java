package com.academy.assetsproject.services;

import com.academy.assetsproject.models.ProductTypes;
import org.springframework.data.domain.Page;
import com.academy.assetsproject.exception.RecordNotFoundException;
import org.springframework.data.domain.Pageable;

public interface ProductTypeService {
    Page<ProductTypes> findByProductTypes(ProductTypes productTypes, Pageable pageable);
    Page<ProductTypes> findAllProductTypes(Pageable pageable);
    ProductTypes findProductTypesById(Long id)throws RecordNotFoundException;
    ProductTypes updateProductTypes(ProductTypes productType, Long id)throws RecordNotFoundException;
    void deleteProductTypes(Long id, Pageable pageable)throws RecordNotFoundException;
}
