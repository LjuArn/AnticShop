package com.example.anticshop.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "items")
public class ItemEntity extends BaseEntity {

    @Column(unique = true, nullable = false, length = 800)
    private String name;
    @Column(length = 4000)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column
    private LocalDate published_on;
    @Column(length = 4000)
    private String imageUrl;
    @Column
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    public ItemEntity() {
    }

    public String getName() {
        return name;
    }

    public ItemEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getPublished_on() {
        return published_on;
    }

    public ItemEntity setPublished_on(LocalDate published_on) {
        this.published_on = published_on;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public ItemEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ItemEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ItemEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public CartEntity getCart() {
        return cart;
    }

    public ItemEntity setCart(CartEntity cart) {
        this.cart = cart;
        return this;
    }
}
