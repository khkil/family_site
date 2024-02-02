package com.example.googoos.domain.cooking.repository;

import com.example.googoos.domain.cooking.entity.CookingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CookingCategoryRepository extends JpaRepository<CookingCategory, Long> {
    Optional<CookingCategory> findByCategoryName(String categoryName);
}


