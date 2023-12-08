package com.example.anticshop.domain.entity;

import com.example.anticshop.domain.entity.enums.OrderConditionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @OneToOne
    private CartEntity cart;

    @Column(nullable = false)
    private LocalDateTime dateOrdered;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private OrderConditionEnum orderCondition;


    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String gsm;


    public OrderEntity() {
    }

    public CartEntity getCart() {
        return cart;
    }

    public OrderEntity setCart(CartEntity cart) {
        this.cart = cart;
        return this;
    }

    public LocalDateTime getDateOrdered() {
        return dateOrdered;
    }

    public OrderEntity setDateOrdered(LocalDateTime dateOrdered) {
        this.dateOrdered = dateOrdered;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OrderEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public OrderConditionEnum getOrderCondition() {
        return orderCondition;
    }

    public OrderEntity setOrderCondition(OrderConditionEnum orderCondition) {
        this.orderCondition = orderCondition;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getGsm() {
        return gsm;
    }

    public OrderEntity setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }
}

//    @Column
//    private BigDecimal orderSum;

//    @OneToOne
//    private Comment comment;