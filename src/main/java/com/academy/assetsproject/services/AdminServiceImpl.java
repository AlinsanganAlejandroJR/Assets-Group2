package com.academy.assetsproject.services;

import com.academy.assetsproject.models.Admin;
import com.academy.assetsproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminServiceImpl implements UserDetailsService {
        @Autowired
        private AdminRepository adminRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Admin admin = adminRepository.findByUserName(username);
            if (admin == null) throw new UsernameNotFoundException("Invalid Admin");

            return new org.springframework.security.core.userdetails.User(admin.getUserName(), admin.getPassword(), getAuthority());
        }

        private List<SimpleGrantedAuthority> getAuthority() {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
}
