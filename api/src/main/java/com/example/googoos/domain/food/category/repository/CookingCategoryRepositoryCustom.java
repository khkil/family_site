package com.example.googoos.domain.food.category.repository;

import com.example.googoos.domain.food.category.dto.CookingCategoryDto;

import java.util.List;

public interface CookingCategoryRepositoryCustom {
    List<CookingCategoryDto> findAllCustom();
}
