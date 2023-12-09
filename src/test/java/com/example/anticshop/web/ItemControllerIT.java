package com.example.anticshop.web;

import com.example.anticshop.domain.entity.*;
import com.example.anticshop.domain.entity.enums.CategoryNameEnum;
import com.example.anticshop.domain.entity.enums.UserRoleEnum;
import com.example.anticshop.repository.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerIT {

//
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    @Autowired
//    private MockMvc mockMvc;
//
//    CartEntity cart1;
//
//    UserEntity testUser, testAdmin;
//
//    ItemEntity testOrder1, testOrder2, testMedal1, testMedal2, testCoin1, testCoin2;
//
//    CategoryEntity testCategoryOrder, testCategoryMedal, testCategoryCoin;
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
//        mockUserRepository.deleteAll();
//        mockUserRoleRepository.deleteAll();
//        mockCategoryRepository.deleteAll();
//
//

//        testOrder1,
//
//                testOrder2
//
//        testMedal1,
//
//                testMedal2
//
//        testCoin1,
//
//                testCoin2
//
//        private static ItemEntity createTestOrder1() {
//            return new ItemEntity()
//                    .setName("orderTest1")
//                    .setDescription("very fine")
//                    .setPrice(BigDecimal.valueOf(222))
//                    .setPublished_on(LocalDate.now())
//                    .setImageUrl("dsfsffsf")
//                    .setYear(1899)
//                    .setCategory(testCategoryCoin)
//                    .setUser("")
//                    .setCart("");
//        }

//
//        List<ItemEntity> testList2 = List.of(testOrder1, testOrder2);
//
//        CategoryEntity testCategoryOrder = new CategoryEntity()
//                .setName(CategoryNameEnum.ORDERS)
//                .setDescription("Some Bulgarian royal orders from 1887 to 1943")
//                .setItems(testList2);
//
//        mockCategoryRepository.saveAndFlush(testCategoryOrder);
//
//        List<ItemEntity> testList3 = List.of(testMedal1, testMedal2);
//        CategoryEntity testCategoryMedal = new CategoryEntity()
//                .setName(CategoryNameEnum.MEDALS)
//                .setDescription("Some Bulgarian royal medals from 1887 to 1943")
//                .setItems(testList3);
//
//        mockCategoryRepository.saveAndFlush(testCategoryMedal);
//
//        List<ItemEntity> testList4 = List.of(testCoin1, testCoin2);
//        CategoryEntity testCategoryCoin = new CategoryEntity()
//                .setName(CategoryNameEnum.COINS)
//                .setDescription("Some Bulgarian coins from 1887 to 1943")
//                .setItems(testList4);
//
//        mockCategoryRepository.saveAndFlush(testCategoryCoin);
//
//        List<ItemEntity> testList1 = List.of(testCoin1, testMedal1);
//        CartEntity cart1 = new CartEntity()
//                .setChosenItems(testList1)
//                .setCountItems((long) testList1.size())
//                .setItemsSum(BigDecimal.valueOf(12));
//
//        mockCartRepository.saveAndFlush(cart1);
//
//        ItemEntity testItemMedal1 = new ItemEntity()
//                .setUser(testUser)
//                .setDescription("descr")
//                .setCategory(testCategoryMedal)
//                .setName("old order")
//                .setPrice(BigDecimal.valueOf(234))
//                .setCart(cart1)
//                .setPublished_on(LocalDate.now())
//                .setImageUrl("img")
//                .setYear(1888);
//
//        mockItemRepository.saveAndFlush(testItemMedal1);
//
//        mockUserRepository.deleteAll();
//        mockUserRoleRepository.deleteAll();
//
//        UserRoleEntity adminRole = new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN);
//        UserRoleEntity userRole = new UserRoleEntity().setUserRole(UserRoleEnum.USER);
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
//    void testGetAllMedals() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/items/medals/all"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("all-medals"))
//                .andExpect(model().attributeExists("medals"));
//    }
//
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testGetAllOrders() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/items/orders/all"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("all-orders"))
//                .andExpect(model().attributeExists("orders"));
//    }
//
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testGetAllCoins() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/items/coins/all"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("all-coins"))
//                .andExpect(model().attributeExists("coins"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin777", roles = "ADMIN")
//    void testGetAllItems() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/items/all"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("all-items"))
//                .andExpect(model().attributeExists("items"));
//    }
//
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testAddItemGet() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/items/add"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("add-item"))
//                .andExpect(model().attributeExists("itemBindingModel"));
//    }
//
//    @Test
//    @WithMockUser(username = "gosho777", roles = "USER")
//    void testGetDetailsItem() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/items/details/{id}"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("details-item"))
//                .andExpect(model().attributeExists("item"));
//    }
//
//
//
//
//    @Test
//    @WithMockUser(username = "admin777", roles = "ADMIN")
//    void testGetEditItem() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/items/edit/{id}"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("edit-item"))
//                .andExpect(model().attributeExists("editedItem"));
//    }
//
//
//
//
//    @Test
//    @WithMockUser(username = "admin123", roles = "ADMIN")
//    void testGetAddItemPostWorksCorrectly() throws Exception {
//        mockMvc.perform(post("/items/add")
//                        .param("name", "Test item name")
//                        .param("year", "1880")
//                        .param("description", "Test item description")
//                        .param("price", "Test item price")
//                        .param("imageUrl", "Test image")
//                        .param("category", "coin")
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("all"));
//    }
//
//
//
//
//    @Test
//    @WithMockUser(username = "admin123", roles = "ADMIN")
//    void testGetAddItemPostDoNotWorksCorrectly() throws Exception {
//        mockMvc.perform(post("/items/add")
//                        .param("name", "Test item name")
//                        .param("year", "1880")
//                        .param("description", "Test item description")
//                        .param("price", "Test item price")
//                        .param("imageUrl", "Test image")
//                        .param("category", "")
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("all"));
//    }
//
//
//

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

}
