package com.example.anticshop.domain.bindingModel;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    @Size(min = 5, max = 20, message = "Full name length must be more than 5 characters")
    private String fullName;
    private boolean isActive;
    @Email
    private String email;
    private String imageUrl;
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

    public boolean isActive() {
        return isActive;
    }

    public UserRegisterBindingModel setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserRegisterBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    //    private List<UserRoleEntity> roles = new ArrayList<>();
//    private Set<OrderEntity> orders;



}
