package com.example.googoos.domain.food.category.repository;

import com.example.googoos.domain.food.category.controller.CookingCategoryController;
import com.example.googoos.domain.food.category.entity.CookingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookingCategoryRepository extends JpaRepository<CookingCategory, Long>, CookingCategoryRepositoryCustom {
}


