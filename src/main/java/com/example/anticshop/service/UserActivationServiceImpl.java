package com.example.anticshop.service;


import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.repository.CartRepository;
import com.example.anticshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private final CartService cartService;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public UserActivationServiceImpl(CartRepository cartRepository,
                                     CartService cartService, UserRepository userRepository) {
        this.cartService = cartService;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void cleanUpObsoleteActivationLinks() {

        userRepository.findAll()
                .stream().map(userEntity -> {
            if (!userEntity.isActive()) {
               userRepository.delete(userEntity);
            }
            return null;
        }).collect(Collectors.toList());

        System.out.println("READY");
    }
}
