package com.example.user.pojo.dto;

public class UserLoginDto {
    private String username;
    private String password;
    private int role;
    private int rem;

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", rem=" + rem +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRem() {
        return rem;
    }

    public void setRem(int rem) {
        this.rem = rem;
    }
}
