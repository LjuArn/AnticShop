package com.example.anticshop.service;

import com.example.anticshop.domain.viewModel.ItemsViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    void addItemToTheCart(Long id, String username);

    List<ItemsViewModel> getItemsInTheCart(String username);

    BigDecimal getItemsPrice(String username);
}
