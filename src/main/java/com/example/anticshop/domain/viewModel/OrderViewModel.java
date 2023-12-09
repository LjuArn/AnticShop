package com.example.anticshop.domain.viewModel;

import com.example.anticshop.domain.entity.CartEntity;
import com.example.anticshop.domain.entity.UserEntity;
import com.example.anticshop.domain.entity.enums.OrderConditionEnum;



import java.time.LocalDateTime;

public class OrderViewModel {

    private Long id;
    private CartEntity cart;
    private LocalDateTime dateOrdered;
    private UserEntity user;
    private OrderConditionEnum orderCondition;
    private String address;
    private String gsm;

    public OrderViewModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public CartEntity getCart() {
        return cart;
    }

    public OrderViewModel setCart(CartEntity cart) {
        this.cart = cart;
        return this;
    }

    public LocalDateTime getDateOrdered() {
        return dateOrdered;
    }

    public OrderViewModel setDateOrdered(LocalDateTime dateOrdered) {
        this.dateOrdered = dateOrdered;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OrderViewModel setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public OrderConditionEnum getOrderCondition() {
        return orderCondition;
    }

    public OrderViewModel setOrderCondition(OrderConditionEnum orderCondition) {
        this.orderCondition = orderCondition;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderViewModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getGsm() {
        return gsm;
    }

    public OrderViewModel setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }
}
