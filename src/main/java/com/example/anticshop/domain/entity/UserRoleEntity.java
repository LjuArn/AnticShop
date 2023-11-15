package com.example.anticshop.domain.entity;

import com.example.anticshop.domain.enums.UserRoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;


@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;


    public UserRoleEntity() {
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public UserRoleEntity setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}
