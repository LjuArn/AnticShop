package com.example.anticshop.service;

import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.entity.enums.UserRoleEnum;

public interface UserRoleService {

   UserRoleEntity getRole(UserRoleEnum userRoleEnum);

}
