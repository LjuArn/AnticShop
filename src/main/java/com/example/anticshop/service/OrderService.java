package com.example.anticshop.service;

import com.example.anticshop.domain.bindingModel.OrderBindingModel;
import com.example.anticshop.domain.viewModel.ItemsViewModel;
import com.example.anticshop.domain.viewModel.OrderViewModel;

import java.util.List;

public interface OrderService {


    List<OrderViewModel> getOrdersByUser(String name);

    void makeOrder(OrderBindingModel orderBindingModel, String userName);

    List<OrderViewModel> getAllOrders();

    void finishOrder(Long orderId);
}
