package com.forcen.e_vote.dtos;

public class AuthDTO {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthDTO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
}
