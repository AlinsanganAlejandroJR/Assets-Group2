package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.ProductTypes;
import com.academy.assetsproject.models.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypesRepository extends PagingAndSortingRepository<ProductTypes, Long> {
    //Page<ProductTypes> findByProduct(Products products, Pageable pageable);
}
