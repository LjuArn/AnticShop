package com.example.anticshop.domain.serviceModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderSummeryInfo {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate published_on;
    private String imageUrl;

    public OrderSummeryInfo() {
    }

    public Long getId() {
        return id;
    }

    public OrderSummeryInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderSummeryInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderSummeryInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderSummeryInfo setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getPublished_on() {
        return published_on;
    }

    public OrderSummeryInfo setPublished_on(LocalDate published_on) {
        this.published_on = published_on;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OrderSummeryInfo setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}



