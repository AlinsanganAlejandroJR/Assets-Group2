package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUserName(String userName);
}
