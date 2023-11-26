package com.example.anticshop.service;

import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.serviceModel.UserServiceModel;


import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);
}
