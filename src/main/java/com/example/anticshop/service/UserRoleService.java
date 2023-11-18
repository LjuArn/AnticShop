package com.example.anticshop.service;

import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.enums.UserRoleEnum;

public interface UserRoleService {

   UserRoleEntity getRole(UserRoleEnum userRoleEnum);

}
