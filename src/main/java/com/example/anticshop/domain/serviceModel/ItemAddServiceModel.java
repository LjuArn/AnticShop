package com.example.anticshop.domain.serviceModel;

import com.example.anticshop.domain.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;

public class ItemAddServiceModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private Integer year;
    private CategoryNameEnum category;

    public ItemAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public ItemAddServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemAddServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
