package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.Products;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.academy.assetsproject.models.Products;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {

}
