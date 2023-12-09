package com.example.anticshop.web;


import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.entity.enums.UserRoleEnum;
import com.example.anticshop.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserLoginControllerIT {

//
//
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    @Autowired
//    private MockMvc mockMvc;
//
//    UserEntity testUser, testAdmin;
//
//    @Autowired
//    private ItemRepository mockItemRepository;
//    @Autowired
//    private CategoryRepository mockCategoryRepository;
//    @Autowired
//    private UserRepository mockUserRepository;
//    @Autowired
//    private UserRoleRepository mockUserRoleRepository;
//
//    @Autowired
//    private CartRepository mockCartRepository;
//
//
//    @BeforeEach
//    void setUp() {
//        mockCartRepository.deleteAll();
//        mockItemRepository.deleteAll();
//        mockCategoryRepository.deleteAll();
//
//
//        mockUserRepository.deleteAll();
//        mockUserRoleRepository.deleteAll();
//
//
//        UserRoleEntity userRole = new UserRoleEntity().setUserRole(UserRoleEnum.USER);
//
//        mockUserRoleRepository.saveAndFlush(userRole);
//
//        testUser = createTestUser();
//        testUser.setRoles(List.of(userRole));
//
//        mockUserRepository.save(testUser);
//
//    }
//
//
//    @AfterEach
//    void tearDown() {
//        mockCartRepository.deleteAll();
//        mockItemRepository.deleteAll();
//        mockUserRepository.deleteAll();
//        mockUserRoleRepository.deleteAll();
//        mockCategoryRepository.deleteAll();
//    }
//
//
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testRegUserOnFailureWorksCorrectly() throws Exception {
//        mockMvc.perform(post("/users/login-error")
//                        .param("fullName", "Test full name")
//                        .param("username", "asgfh")
//                        .param("email", "as@abv")
//                        .param("password", "Test password")
//                        .param("confirmPassword", "Test password")
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("login"));
//    }
//
//
//
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testRegUserPostNotWorksCorrectly() throws Exception {
//        mockMvc.perform(post("/users/login-error")
//                        .param("fullName", "Test full name")
//                        .param("username", "hahahah")
//                        .param("email", "")
//                        .param("password", "Test password")
//                        .param("confirmPassword", "Test password")
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("login"));
//    }
//
//
//
//
//
//
//
//    private static UserEntity createTestUser() {
//        return new UserEntity()
//                .setUsername("gosho777")
//                .setFullName("Gosho Gosho")
//                .setEmail("gosho@abv.bg")
//                .setPassword("UserAAAAAAAA");
//    }
//
//

}
