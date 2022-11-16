package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.Products;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface ProductRepository extends PagingAndSortingRepository<Products, Long> {



}
