package com.example.anticshop.web;

import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.entity.UserRoleEntity;
import com.example.anticshop.domain.entity.enums.UserRoleEnum;
import com.example.anticshop.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    UserEntity testUser, testAdmin;

    @Autowired
    private ItemRepository mockItemRepository;
    @Autowired
    private CategoryRepository mockCategoryRepository;
    @Autowired
    private UserRepository mockUserRepository;
    @Autowired
    private UserRoleRepository mockUserRoleRepository;
    @Autowired
    private CartRepository mockCartRepository;
    @Autowired
    private OrderRepository mockOrderRepository;

    @BeforeEach
    void setUp() {
        mockCartRepository.deleteAll();
        mockItemRepository.deleteAll();
        mockCategoryRepository.deleteAll();
        mockUserRepository.deleteAll();
        mockUserRoleRepository.deleteAll();
        mockOrderRepository.deleteAll();


        UserRoleEntity adminRole = new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN);
        UserRoleEntity userRole = new UserRoleEntity().setUserRole(UserRoleEnum.USER);
        mockUserRoleRepository.saveAndFlush(userRole);
        mockUserRoleRepository.saveAndFlush(adminRole);

        testUser = createTestUser();
        testUser.setRoles(List.of(userRole));

        testAdmin = createTestAdmin();
        testAdmin.setRoles(List.of(adminRole, userRole));

        mockUserRepository.save(testUser);
        mockUserRepository.save(testAdmin);

    }


    @AfterEach
    void tearDown() {
        mockCartRepository.deleteAll();
        mockItemRepository.deleteAll();
        mockUserRepository.deleteAll();
        mockUserRoleRepository.deleteAll();
        mockCategoryRepository.deleteAll();
    }














    private static UserEntity createTestAdmin() {
        return new UserEntity()
                .setUsername("admin777")
                .setFullName("Admin Adminov")
                .setEmail("admin@abv.bg")
                .setPassword("AdmAAAAAAAAA");
    }

    private static UserEntity createTestUser() {
        return new UserEntity()
                .setUsername("gosho777")
                .setFullName("Gosho Gosho")
                .setEmail("gosho@abv.bg")
                .setPassword("UserAAAAAAAA");
    }




}
