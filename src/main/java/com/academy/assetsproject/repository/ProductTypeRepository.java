package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.ProductTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductTypes, Long> {
}
