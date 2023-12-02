package com.example.anticshop.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity {


    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemEntity> chosenItems;

    private Long countItems;

    private BigDecimal itemsSum;


    public CartEntity() {
        this.chosenItems = new ArrayList<>();
        this.countItems = 0L;
        this.itemsSum = BigDecimal.ZERO;
    }


    public List<ItemEntity> getChosenItems() {
        return chosenItems;
    }

    public CartEntity setChosenItems(List<ItemEntity> chosenItems) {
        this.chosenItems = chosenItems;
        return this;
    }

    public Long getCountItems() {
        return countItems;
    }

    public CartEntity setCountItems(Long countItems) {
        this.countItems = countItems;
        return this;
    }

    public BigDecimal getItemsSum() {
        return itemsSum;
    }

    public CartEntity setItemsSum(BigDecimal itemsSum) {
        this.itemsSum = itemsSum;
        return this;
    }


    public void addItem(ItemEntity item) {
        chosenItems.add(item);
    }

    public void increaseItemsSum(BigDecimal itemPrice) {

        BigDecimal sum = getItemsSum();

        setItemsSum(sum.add(itemPrice));
        countItems++;
    }

    public void decreaseItemsSum(BigDecimal itemPrice) {

        BigDecimal sum = getItemsSum();

        setItemsSum(sum.subtract(itemPrice));
        countItems--;
    }


}
