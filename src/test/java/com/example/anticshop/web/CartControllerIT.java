package com.example.anticshop.web;


import com.example.anticshop.domain.entity.*;
import com.example.anticshop.domain.entity.enums.CategoryNameEnum;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@AutoConfigureMockMvc
//public class CartControllerIT {
//
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    @Autowired
//    private MockMvc mockMvc;
//
//    UserEntity testUser, testAdmin;
//    ItemEntity testOrder, testMedal, testCoin;
//    CartEntity testCart;
//
//    @Autowired
//    private static ItemRepository mockItemRepository;
//    @Autowired
//    private CategoryRepository mockCategoryRepository;
//    @Autowired
//    private UserRepository mockUserRepository;
//    @Autowired
//    private UserRoleRepository mockUserRoleRepository;
//    @Autowired
//    private CartRepository mockCartRepository;
//    @Autowired
//    private OrderRepository mockOrderRepository;
//
//    @BeforeEach
//    void setUp() {
//        mockCartRepository.deleteAll();
//        mockCategoryRepository.deleteAll();
//        mockUserRepository.deleteAll();
//        mockUserRoleRepository.deleteAll();
//        mockOrderRepository.deleteAll();
//
//
//        ItemEntity createTestMedal2 = new ItemEntity()
//                .setName("medalTest1")
//                .setDescription("very fine")
//                .setPrice(BigDecimal.valueOf(222))
//                .setPublished_on(LocalDate.now())
//                .setImageUrl("dsfsffsf")
//                .setYear(1899);
//
//        mockItemRepository.save(createTestMedal2);
//        List<ItemEntity> testList2 = List.of(createTestMedal2);
//
//        testCart = createTestCart();
//        mockCartRepository.saveAndFlush(testCart);
//
//        CategoryEntity testCategoryMedal = new CategoryEntity()
//                .setName(CategoryNameEnum.MEDALS)
//                .setDescription("Some Bulgarian royal orders from 1887 to 1943")
//                .setItems(testList2);
//
//        mockCategoryRepository.saveAndFlush(testCategoryMedal);
//
//
//        UserRoleEntity adminRole = new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN);
//        UserRoleEntity userRole = new UserRoleEntity().setUserRole(UserRoleEnum.USER);
//        mockUserRoleRepository.saveAndFlush(userRole);
//        mockUserRoleRepository.saveAndFlush(adminRole);
//
//
//        testUser = createTestUser();
//        testUser.setRoles(List.of(userRole));
//
//        testAdmin = createTestAdmin();
//        testAdmin.setRoles(List.of(adminRole, userRole));
//
//        mockUserRepository.save(testUser);
//        mockUserRepository.save(testAdmin);
//
//    }
//
//
//    @AfterEach
//    void tearDown() {
//        mockCartRepository.deleteAll();
//        mockUserRepository.deleteAll();
//        mockUserRoleRepository.deleteAll();
//        mockCategoryRepository.deleteAll();
//    }
//
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testGetCart() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/cart"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("cart"))
//                .andExpect(model().attributeExists("cartItems", "itemsPrice", "countItems"));
//    }
//
//
//
//
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testAddItemsToTheCartWorksCorrectly() throws Exception {
//
//        mockMvc.perform(patch("/cart/add/{id}", testCart.getId())
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/items/all"));
//
//    }
//
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testRemoveItemFromCartWorksCorrectly() throws Exception {
//
//        mockMvc.perform(patch("/cart/remove/{id}", testCart.getId())
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/cart"));
//
//    }
//
//
//    private static CartEntity createTestCart() {
//        ItemEntity createTestMedal1 = new ItemEntity()
//                .setName("medalTest1")
//                .setDescription("very fine")
//                .setPrice(BigDecimal.valueOf(222))
//                .setPublished_on(LocalDate.now())
//                .setImageUrl("dsfsffsf")
//                .setYear(1899);
//        mockItemRepository.saveAndFlush(createTestMedal1);
//        return new CartEntity()
//                .setItemsSum(BigDecimal.valueOf(56))
//                .setCountItems(3L)
//                .setChosenItems(List.of(createTestMedal1));
//    }
//
//    private static UserEntity createTestAdmin() {
//        return new UserEntity()
//                .setUsername("admin777")
//                .setFullName("Admin Adminov")
//                .setEmail("admin@abv.bg")
//                .setPassword("AdmAAAAAAAAA");
//    }
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
//}


