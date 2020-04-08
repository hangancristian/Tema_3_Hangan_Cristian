package com.example.tema_3_hangan_cristian;

public class User {
    public String getUserId() {
        return userId;
    }

    private String userId;
    private String name;
    private String username;
    private String email;

    public User(String userId, String name, String username, String email) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
