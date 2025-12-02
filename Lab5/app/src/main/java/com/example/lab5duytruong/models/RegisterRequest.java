package com.example.lab5duytruong.models;
public class RegisterRequest {
    private String email;
    private String password;
    private String full_name;

    public RegisterRequest(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.full_name = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}

