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


}



//    @OneToOne
//    private Comment comment;