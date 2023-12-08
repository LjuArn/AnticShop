package com.example.anticshop.domain.entity;


import com.example.anticshop.domain.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Column(name = "name", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;

    @Column(name = "description", length = 4000)
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<ItemEntity> items;

    public CategoryEntity() {
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public CategoryEntity setItems(List<ItemEntity> items) {
        this.items = items;
        return this;
    }
}
