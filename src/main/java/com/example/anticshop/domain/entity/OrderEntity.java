package com.example.anticshop.domain.entity;

import com.example.anticshop.domain.entity.enums.OrderConditionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @OneToOne
    private CartEntity cart;

    @Column(nullable = false)
    private LocalDate dateOrdered;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private OrderConditionEnum orderCondition;

    public OrderEntity() {
    }


    public CartEntity getCart() {
        return cart;
    }

    public OrderEntity setCart(CartEntity cart) {
        this.cart = cart;
        return this;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public OrderEntity setDateOrdered(LocalDate dateOrdered) {
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
}

//    @Column
//    private BigDecimal orderSum;

//    @OneToOne
//    private Comment comment;