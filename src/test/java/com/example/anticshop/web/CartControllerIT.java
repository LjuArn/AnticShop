package com.example.anticshop.web;


import com.example.anticshop.domain.entity.ItemEntity;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerIT {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    UserEntity testUser, testAdmin;
    ItemEntity testOrder, testMedal, testCoin;

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



 @Test
    @WithMockUser(username = "gosho777", roles = "USER")
    void testGetCart() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cart"))
                .andExpect(status().isOk())
                .andExpect(view().name("cart"))
                .andExpect(model().attributeExists("cartItems", "itemsPrice", "countItems"));
    }





    @Test
    @WithMockUser(username = "gosho777", roles = "USER")
    void testRegistration() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("userRegisterBindingModel"));
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



//
//    @Test
//    @WithMockUser(username = "user1", roles = "USER")
//    void testAddingProductToCart_WorksCorrectly() throws Exception {
//
//        mockMvc.perform(MockMvcRequestBuilders.patch("/cart/add/{id}", pizzaOne.getId())
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/menu/pizza"));
//
//    }
//
//    @Test
//    @WithMockUser(username = "user1", roles = "USER")
//    void testRemoveFromCart_WorksCorrectly() throws Exception {
//
//        mockMvc.perform(patch("/cart/remove/{id}", burgerOne.getId())
//                        .param("id", burgerOne.getId().toString()).with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/cart"));
//
//    }