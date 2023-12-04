package com.example.anticshop.service;

import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.entity.enums.UserRoleEnum;
import com.example.anticshop.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnticUserDetailServiceTest {

    private AnticUserDetailService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new AnticUserDetailService(mockUserRepository);
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("asas"));
    }

    @Test
    void testUserFoundException() {

        //Arrange
        UserEntity testUserEntity = createTestUser();
        when(mockUserRepository.findByUsername(testUserEntity.getUsername()))
                .thenReturn(Optional.of(testUserEntity));

        //Act
        UserDetails userDetails =
                serviceToTest.loadUserByUsername(testUserEntity.getUsername());

        //Assert
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(testUserEntity.getUsername(), userDetails.getUsername(), "");
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword(), "");
        Assertions.assertEquals(2, userDetails.getAuthorities().size(), "");

        Assertions. assertTrue(
                containsAuthority(userDetails, "ROLE_" + UserRoleEnum.ADMIN),
                "The user is not admin");
       Assertions. assertTrue(
                containsAuthority(userDetails, "ROLE_" + UserRoleEnum.USER),
                "The user is not user");
    }




    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
        return userDetails
                .getAuthorities()
                .stream()
                .anyMatch(a -> expectedAuthority.equals(a.getAuthority()));
    }
    private static UserEntity createTestUser() {
        return new UserEntity()
                .setFullName("FULL NAME")
                .setUsername("USERNAME")
                .setPassword("22222")
                .setActive(false)
                .setImageUrl("asd")
                .setEmail("pesho@softuni.bg")
                .setRoles(List.of(
                        new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN),
                        new UserRoleEntity().setUserRole(UserRoleEnum.USER)
                ));
    }

}
