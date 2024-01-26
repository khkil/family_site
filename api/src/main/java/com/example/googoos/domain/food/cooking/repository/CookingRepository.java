package com.example.googoos.domain.food.cooking.repository;

import com.example.googoos.domain.food.cooking.entity.CookingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookingRepository extends JpaRepository<CookingCategory, Long>, CookingRepositoryCustom {
}


