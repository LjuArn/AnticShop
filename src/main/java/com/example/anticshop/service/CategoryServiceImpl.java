package com.example.anticshop.service;

import com.example.anticshop.domain.entity.CategoryEntity;
import com.example.anticshop.domain.entity.enums.CategoryNameEnum;
import com.example.anticshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryNameEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}

