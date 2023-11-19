package com.example.anticshop.repository;

import com.example.anticshop.domain.entity.ItemEntity;
import com.example.anticshop.domain.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

List<ItemEntity>findByCategory_Name(CategoryNameEnum category_name);
}
