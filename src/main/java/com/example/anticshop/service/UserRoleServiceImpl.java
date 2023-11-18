package com.example.anticshop.service;

import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.enums.UserRoleEnum;
import com.example.anticshop.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public UserRoleEntity getRole(UserRoleEnum userRoleEnum) {
        return userRoleRepository.findByUserRole(userRoleEnum);
    }
}
