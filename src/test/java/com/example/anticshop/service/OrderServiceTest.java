package com.example.anticshop.service;


import com.example.anticshop.repository.OrderRepository;
import com.example.anticshop.service.exeption.ObjectNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private UserService userService;
    @Mock
    private OrderRepository mockOrderRepository;
    @Mock
    private ModelMapper modelMapper;

    private OrderServiceImpl serviceToTest;

    @BeforeEach
    void setUp() {
        serviceToTest = new OrderServiceImpl(userService, mockOrderRepository, modelMapper);
        mockOrderRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        mockOrderRepository.deleteAll();
    }


    @Test
    void findOrderByUsernameNotSuccessful() {
        Assertions.assertThrows(NullPointerException.class,
                () -> this.serviceToTest.getOrdersByUser("adasddadfsfsdfsdfggdg"));
    }

    @Test
    void finishOrderByIdNotSuccessful() {
        Assertions.assertThrows(ObjectNotFoundException.class,
                () -> this.serviceToTest.finishOrder(-1L));
    }
}
