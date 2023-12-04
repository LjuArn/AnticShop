package com.example.anticshop.service;//package com.example.mobilele2023new.service;

import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class AnticUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public AnticUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::userDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!!"));
    }




    private UserDetails userDetails(UserEntity userEntity) {
        return
                User.withUsername(userEntity.getUsername())
                        .password(userEntity.getPassword())
                        .authorities(userEntity
                                .getRoles()
                                .stream()
                                .map(this::grantedAuthority)
                                .collect(Collectors.toSet()))
                        .build();
    }

    private GrantedAuthority grantedAuthority(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getUserRole().name());
    }


}
