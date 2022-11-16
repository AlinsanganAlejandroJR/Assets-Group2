package com.academy.assetsproject.services;

import com.academy.assetsproject.enums.UserType;
import com.academy.assetsproject.models.Users;
import com.academy.assetsproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    /*private List<UserType> getAuthority(Users users){
        List<UserType> roleByUserId = Collections.singletonList(users.getRole());
        List<UserType> authorities = roleByUserId.stream().map(role -> new SimpleGrantedAuthority("ROLE_").t)
        return roleByUserId;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid User");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        return new User(user.getUserName(),user.getPassword(), Arrays.asList(authority));
    }
}
