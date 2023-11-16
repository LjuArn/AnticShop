package com.example.anticshop.repository;

import com.example.anticshop.domain.entity.ChosenItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChosenItemRepository extends JpaRepository<ChosenItemEntity, Long> {
}
