package com.example.anticshop.domain.bindingModel;

import com.example.anticshop.domain.entity.CategoryEntity;
import com.example.anticshop.domain.entity.enums.CategoryNameEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ItemBindingModel {
    @NotEmpty
    @Size(min = 5, max = 20, message = " Name length must be between 5 and 20 characters")
    private String name;
    @Size(min = 5)
    private String description;
    private BigDecimal price;
   // @Size(min = 5, max= 512)
    private String imageUrl;
    @NotNull
    private CategoryNameEnum category;

    public ItemBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ItemBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}



//    private LocalDate published_on;
//    private UserEntity user;