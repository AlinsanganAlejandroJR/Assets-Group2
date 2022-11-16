package com.academy.assetsproject.services;

import com.academy.assetsproject.models.User;
import com.academy.assetsproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {
        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByUserName(username);
            if (user == null) throw new UsernameNotFoundException("Invalid User");

            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
        }

        private List<SimpleGrantedAuthority> getAuthority() {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
}
