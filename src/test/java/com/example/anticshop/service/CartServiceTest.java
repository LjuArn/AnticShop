package com.example.anticshop.service;


import com.example.anticshop.domain.entity.CartEntity;
import com.example.anticshop.repository.CartRepository;
import com.example.anticshop.repository.ItemRepository;
import com.example.anticshop.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private ItemRepository mockItemRepository;

    @Mock
    private CartRepository mockCartRepository;

    @Mock
    private ModelMapper mockModelMapper;

    private CartServiceImpl cartServiceToTest;


    @BeforeEach
    void setUp() {
        cartServiceToTest = new CartServiceImpl(mockUserRepository, mockItemRepository,
                mockCartRepository, mockModelMapper);
        mockUserRepository.deleteAll();
        mockItemRepository.deleteAll();
        mockCartRepository.deleteAll();
    }


    @AfterEach
    void tearDown() {
        mockUserRepository.deleteAll();
        mockItemRepository.deleteAll();
        mockCartRepository.deleteAll();
    }


    @Test
    void testSaveInvoked() {
        cartServiceToTest.getNewCart();
        verify(mockCartRepository).saveAndFlush(any());
    }

    @Test
    void testReturnedCart() {

        CartEntity newCart = cartServiceToTest.getNewCart();

        Assertions.assertEquals(0, newCart.getChosenItems().size());
        Assertions.assertEquals(BigDecimal.ZERO, newCart.getItemsSum());
    }
}
