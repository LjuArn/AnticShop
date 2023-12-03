package com.example.anticshop.service;

import com.example.anticshop.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private final UserRepository userRepository;

    public UserActivationServiceImpl( UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void cleanUpActivation() {

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
