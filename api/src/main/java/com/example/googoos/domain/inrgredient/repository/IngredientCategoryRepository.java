package com.example.googoos.domain.inrgredient.repository;

import com.example.googoos.domain.inrgredient.entity.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Long> {
    Optional<IngredientCategory> findByCategoryName(String categoryName);
}