package com.example.fooddelivery.Model;

public class UserModel
{
    String email;
    String password;

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserModel()
    {

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
}
