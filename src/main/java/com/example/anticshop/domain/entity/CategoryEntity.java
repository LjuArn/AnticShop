package com.example.anticshop.domain.entity;


import com.example.anticshop.domain.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Column(name = "name", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
