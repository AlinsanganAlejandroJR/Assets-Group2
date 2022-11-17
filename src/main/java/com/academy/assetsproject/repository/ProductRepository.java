package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.Products;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Products, Long> {



}
