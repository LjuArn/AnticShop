package com.example.anticshop.service;


import com.example.anticshop.domain.serviceModel.ItemAddServiceModel;
import com.example.anticshop.repository.ItemRepository;
import com.example.anticshop.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository mockItemRepository;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private ModelMapper mockModelMapper;

    @Mock
    private CategoryService mockCategoryService;


    private ItemServiceImpl itemServiceToTest;

    @BeforeEach
    void setUp() {
        itemServiceToTest = new ItemServiceImpl(mockItemRepository, mockUserRepository,
                mockModelMapper, mockCategoryService);

        mockItemRepository.deleteAll();
        mockUserRepository.deleteAll();
    }


    @AfterEach
    void tearDown() {
        mockItemRepository.deleteAll();
        mockUserRepository.deleteAll();
    }


//
//    @Test
//    void findItemByIdException(Long id) {
//        Assertions.assertThrows(ObjectNotFoundException.class,
//                () -> this.serviceToTest.findByIdItem((long)-12));
//    }
//


}

