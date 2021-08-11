package com.example.storyDrops.dto;

public class LoginResponse {
    private String message, fullname, email, token;

    public LoginResponse() {
    }

    public LoginResponse(String message, String fullname, String email, String token) {
        this.message = message;
        this.fullname = fullname;
        this.email = email;
        this.token = token;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}

