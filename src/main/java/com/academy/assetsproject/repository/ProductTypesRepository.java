package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.ProductTypes;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductTypesRepository extends PagingAndSortingRepository<ProductTypes, Long> {
    //Page<ProductTypes> findByProduct(Products products, Pageable pageable);
}
