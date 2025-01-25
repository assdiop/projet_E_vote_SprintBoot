package com.forcen.e_vote.dtos;

public class AuthResponseDTO {

    private UserDTO user;
    private String token;

    public UserDTO getUser() {
        return user;
    }

    public AuthResponseDTO(UserDTO user, String token) {
        this.user = user;
        this.token = token;
    }

    public AuthResponseDTO() {
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
