package com.example.anticshop.domain.entity;

import com.example.anticshop.domain.enums.OrderConditionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @Column(nullable = false)
    private LocalDate dateOrdered;

    @Column
    private BigDecimal orderSum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<ChosenItemEntity> chosenItems = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderConditionEnum orderCondition;

    public OrderEntity() {
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public OrderEntity setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
        return this;
    }

    public BigDecimal getOrderSum() {
        return orderSum;
    }

    public OrderEntity setOrderSum(BigDecimal orderSum) {
        this.orderSum = orderSum;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OrderEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public List<ChosenItemEntity> getChosenItems() {
        return chosenItems;
    }

    public OrderEntity setChosenItems(List<ChosenItemEntity> chosenItems) {
        this.chosenItems = chosenItems;
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



//    @OneToOne
//    private Comment comment;