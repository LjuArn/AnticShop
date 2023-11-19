package com.example.anticshop.repository;

import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByUserRole(UserRoleEnum userRole);
}

