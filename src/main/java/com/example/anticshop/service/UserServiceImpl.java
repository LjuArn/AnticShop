package com.example.anticshop.service;


import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.entity.enums.UserRoleEnum;
import com.example.anticshop.domain.serviceModel.UserServiceModel;
import com.example.anticshop.domain.viewModel.UsersViewModel;
import com.example.anticshop.repository.UserRepository;
import com.example.anticshop.service.exeption.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        user.setActive(true);
        userRepository.save(user);

    }

    @Override
    public List<UsersViewModel> getAllUsers() {
        return userRepository.findAll().stream().map(userEntity ->
                modelMapper.map(userEntity, UsersViewModel.class))
                .collect(Collectors.toList());
    }



    @Override
    public UserEntity editUserStatus(Long id,
                                 UserServiceModel userChangeStatus) {

        UserEntity user = this.userRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("User not found"));



        if(user.isActive()){
            user.setActive(userChangeStatus.isActive());
            this.userRepository.saveAndFlush(user);
        }else {
            user.setActive(true);
            this.userRepository.saveAndFlush(user);
        }


        return null;
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new ObjectNotFoundException("User not found"));
    }




}

