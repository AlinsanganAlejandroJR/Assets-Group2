package com.academy.assetsproject.Repository;

import com.academy.assetsproject.models.Products;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {

}
