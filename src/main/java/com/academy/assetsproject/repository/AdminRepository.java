package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.Admin;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdminRepository extends PagingAndSortingRepository<Admin, Long> {
    Admin findByUserName(String userName);
}
