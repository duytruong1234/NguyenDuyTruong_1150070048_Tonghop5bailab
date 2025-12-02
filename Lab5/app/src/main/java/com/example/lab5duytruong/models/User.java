package com.example.lab5duytruong.models;

public class User {
    private int id;
    private String email;
    private String fullName;

    public User() {
    }
    public User(int id, String email, String fullName) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

