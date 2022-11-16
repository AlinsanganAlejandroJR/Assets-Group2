package com.academy.assetsproject.repository;

import com.academy.assetsproject.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository <Users, Long> {
    Users findByUserName(String user_name);
}
