package com.forcen.e_vote.controllers;

import com.forcen.e_vote.dtos.UserDTO;
import com.forcen.e_vote.entities.User;
import com.forcen.e_vote.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UtilisateurController {
    private final UserService userService;

    public UtilisateurController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO user) {
        return userService.creerUtilisateur(user);
    }
}

