package com.example.anticshop.domain.bindingModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    @Size(min = 5, max = 20, message = "Full name length must be more than 5 characters")
    private String fullName;
    @Email
    private String email;
    @Size(min = 3, max = 20, message = "Username length must be more than 3 characters")
    private String username;
    @Size(min = 3 , max = 20, message = "Password length must be more than 3 characters")
    private String password;
    @Size(min = 3, max = 20, message = "Confirm password length must be more than 3 characters")
    private String confirmPassword;


    public UserRegisterBindingModel() {
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

}
