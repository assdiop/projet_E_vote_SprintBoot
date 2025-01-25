package com.forcen.e_vote.services;

import com.forcen.e_vote.dtos.UserDTO;
import com.forcen.e_vote.entities.User;
import com.forcen.e_vote.mapper.UserMapper;
import com.forcen.e_vote.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO findUtilisateurByUsername(String username) {
        return userMapper.toDTO(
                userRepository.findByEmail(username).orElseThrow(
                        () -> new RuntimeException("User not found"))
        );
    }



    public User creerUtilisateur(UserDTO user) {
        return userRepository.save(userMapper.toEntity(user));
    }


}
