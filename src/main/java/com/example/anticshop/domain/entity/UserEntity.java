package com.example.anticshop.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String fullName;

    @Column
    private boolean isActive;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch =FetchType.EAGER)
    private Set<OrderEntity> orders;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<ItemEntity> items;

    @OneToOne
    private CartEntity cart;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public UserEntity setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }

    public Set<ItemEntity> getItems() {
        return items;
    }

    public UserEntity setItems(Set<ItemEntity> items) {
        this.items = items;
        return this;
    }


    public CartEntity getCart() {
        return cart;
    }

    public UserEntity setCart(CartEntity cart) {
        this.cart = cart;
        return this;
    }
}


//    @OneToMany
//    private List<Comment> comments;