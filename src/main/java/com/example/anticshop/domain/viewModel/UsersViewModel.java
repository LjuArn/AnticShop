package com.example.anticshop.domain.viewModel;

public class UsersViewModel {

    private Long id;
    private String username;
    private String email;
    private String fullName;
    private boolean isActive;

    public UsersViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UsersViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UsersViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsersViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UsersViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UsersViewModel setActive(boolean active) {
        isActive = active;
        return this;
    }
//
//
//    private List<UserRoleEntity> roles = new ArrayList<>();
//    private Set<OrderEntity> orders;
//    private Set<ItemEntity> items;
//    private CartEntity cart;


}
