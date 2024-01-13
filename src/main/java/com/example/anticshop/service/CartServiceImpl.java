package com.example.anticshop.service;


import com.example.anticshop.domain.entity.CartEntity;
import com.example.anticshop.domain.entity.ItemEntity;
import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.viewModel.ItemsViewModel;
import com.example.anticshop.repository.CartRepository;
import com.example.anticshop.repository.ItemRepository;
import com.example.anticshop.repository.UserRepository;
import com.example.anticshop.service.exeption.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {


    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;


    public CartServiceImpl(UserRepository userRepository,
                           ItemRepository itemRepository, CartRepository cartRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
    }


    public CartEntity getNewCart() {
        CartEntity shoppingCart = new CartEntity();
        cartRepository.saveAndFlush(shoppingCart);
        return shoppingCart;
    }


    @Transactional
    @Override
    public void addItemToTheCart(Long id, String username) {

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with id" + id + "not found"));
        ItemEntity item = itemRepository.findItemEntityById(id);

        if (user.getCart() == null) {
            user.setCart(getNewCart());
        }
        user.getCart().addItem(item);
        item.setCart(user.getCart());
        item.setUser(user);
        user.getCart().increaseItemsSum(item.getPrice());

    }

    @Override
    public List<ItemsViewModel> getItemsInTheCart(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with username" + username + "not found"));


        // new add//
        if (user.getCart() == null) {
            user.setCart(getNewCart());
        }
        return user
                .getCart()
                .getChosenItems()
                .stream()
                .map(item -> {
                    ItemsViewModel itemsViewModel =
                            modelMapper.map(item, ItemsViewModel.class);
                    return itemsViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public BigDecimal getItemsPrice(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with username" + username + "not found"));

        // new add//
        if (user.getCart() == null) {
            user.setCart(getNewCart());
        }


        return user.getCart().getItemsSum();

    }

    @Transactional
    @Override
    public void removeItemFromTheCart(Long id, String username) {

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with id" + id + "not found"));
        ItemEntity item = itemRepository.findItemEntityById(id);

        CartEntity cart = user.getCart();
        cart.getChosenItems().remove(item);
        cart.decreaseItemsSum(item.getPrice());

        item.setUser(userRepository.findByUsername("ADMIN")
                .orElseThrow(() -> new ObjectNotFoundException("User with username" + username + "not found")));
        item.setCart(null);

        itemRepository.saveAndFlush(item);
        cartRepository.saveAndFlush(cart);

    }

}


