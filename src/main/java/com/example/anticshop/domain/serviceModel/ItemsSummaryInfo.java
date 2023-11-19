package com.example.anticshop.domain.serviceModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemsSummaryInfo {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate published_on;
    private String imageUrl;

    public ItemsSummaryInfo() {
    }

    public Long getId() {
        return id;
    }

    public ItemsSummaryInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemsSummaryInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemsSummaryInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemsSummaryInfo setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getPublished_on() {
        return published_on;
    }

    public ItemsSummaryInfo setPublished_on(LocalDate published_on) {
        this.published_on = published_on;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemsSummaryInfo setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}



