package com.example.anticshop.service;

import com.example.anticshop.domain.entity.CategoryEntity;
import com.example.anticshop.domain.entity.enums.CategoryNameEnum;

public interface CategoryService {
    CategoryEntity findByCategoryNameEnum(CategoryNameEnum category);
}
