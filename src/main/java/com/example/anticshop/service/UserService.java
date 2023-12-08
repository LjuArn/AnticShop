package com.example.anticshop.service;

import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.serviceModel.UserServiceModel;
import com.example.anticshop.domain.viewModel.UsersViewModel;


import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    List<UsersViewModel> getAllUsers();

    UserEntity editUserStatus(Long id,
                              UserServiceModel userChangeStatus);


    UserEntity getUserByUsername(String username);
}
