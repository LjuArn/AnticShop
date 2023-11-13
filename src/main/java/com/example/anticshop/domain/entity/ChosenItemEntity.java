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



}
