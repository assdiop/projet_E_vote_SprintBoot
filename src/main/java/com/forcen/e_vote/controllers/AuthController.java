package com.forcen.e_vote.controllers;


import com.forcen.e_vote.config.security.JwtUtils;
import com.forcen.e_vote.dtos.AuthDTO;
import com.forcen.e_vote.dtos.AuthResponseDTO;
import com.forcen.e_vote.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO authDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword()));
        if(!authenticate.isAuthenticated()) {
            return new ResponseEntity<>("Email ou mot de passe incorrecte", HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtils.generateToken(authenticate);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(
                userService.findUtilisateurByUsername(authDto.getUsername()),
                token
        );

        return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
    }
}
