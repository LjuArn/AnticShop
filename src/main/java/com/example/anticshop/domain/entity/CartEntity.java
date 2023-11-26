package com.example.anticshop.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity {

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<ItemEntity> chosenItems = new ArrayList<>();

    public CartEntity() {
    }

    public List<ItemEntity> getChosenItems() {
        return chosenItems;
    }

    public CartEntity setChosenItems(List<ItemEntity> chosenItems) {
        this.chosenItems = chosenItems;
        return this;
    }
}
