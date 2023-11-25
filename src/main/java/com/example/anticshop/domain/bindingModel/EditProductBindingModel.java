package com.example.anticshop.domain.bindingModel;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class EditProductBindingModel {

    @Size(min = 5)
    private String description;
    @Positive
    private BigDecimal price;

    public EditProductBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public EditProductBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public EditProductBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
