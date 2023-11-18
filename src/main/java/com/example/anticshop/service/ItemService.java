package com.example.anticshop.service;

import com.example.anticshop.domain.serviceModel.OrderSummeryInfo;

import java.util.List;

public interface ItemService {
    List<OrderSummeryInfo> getAllOrders();
}
