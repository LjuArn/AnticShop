package com.example.anticshop.domain.viewModel;


import com.example.anticshop.domain.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;

public class ItemsViewModel {

    private Long id;
    private String description;
    private String imageUrl;
    private String name;
    private BigDecimal price;
    private String category;


    public ItemsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemsViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemsViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ItemsViewModel setCategory(String category) {
        this.category = category;
        return this;
    }
}
