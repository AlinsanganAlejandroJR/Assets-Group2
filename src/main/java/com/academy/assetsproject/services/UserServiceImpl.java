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

import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    private List<SimpleGrantedAuthority> getAuthority(Users User){
        if(User.getRole().equals(UserType.ROLE_ADMIN)){
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid User");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        return new User(user.getUserName(), user.getPassword(), Arrays.asList(authority));
    }
}
