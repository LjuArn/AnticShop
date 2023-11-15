package com.example.anticshop.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "chosen_item")
public class ChosenItemEntity extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public ChosenItemEntity() {
    }

    public String getName() {
        return name;
    }

    public ChosenItemEntity setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ChosenItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public ChosenItemEntity setOrder(OrderEntity order) {
        this.order = order;
        return this;
    }
}
