package com.example.anticshop.repository;

import com.example.anticshop.domain.entity.UserEntity;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity>findByUsername(String username);

    UserEntity getById(Long id);
}
