package com.forcen.e_vote.config.security;

import com.forcen.e_vote.entities.User;
import com.forcen.e_vote.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class CustomerUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomerUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByUsername(username);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+ user.getRoles())));
    }

    public User findUserByUsername(String username) {
        return userRepository.findByEmail(username).orElseThrow(
                        () -> new RuntimeException("User not found")
        );
    }
}
