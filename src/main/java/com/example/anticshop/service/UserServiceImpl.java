package com.example.anticshop.service;


import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.entity.enums.UserRoleEnum;
import com.example.anticshop.domain.serviceModel.UserServiceModel;
import com.example.anticshop.domain.viewModel.ItemsViewModel;
import com.example.anticshop.repository.UserRepository;
import com.example.anticshop.service.exeption.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleServiceImpl userRoleServiceImpl;


    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           UserRoleServiceImpl userRoleServiceImpl) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleServiceImpl = userRoleServiceImpl;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        final UserRoleEntity userRole = userRoleServiceImpl.getRole(UserRoleEnum.USER);

        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        user.setRoles(new ArrayList<>(Collections.singletonList(userRole)));
        userRepository.save(user);

    }

//    @Override
//    public UserEntity getUserByUsername(String username) {
//        return userRepository.findByUsername(username)
//                .orElseThrow(()-> new ObjectNotFoundException("User not found"));
//    }


}

