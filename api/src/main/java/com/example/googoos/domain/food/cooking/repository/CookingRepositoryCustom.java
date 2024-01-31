package com.example.googoos.domain.food.cooking.repository;

import com.example.googoos.domain.food.cooking.dto.CookingDetailDto;
import com.example.googoos.domain.food.cooking.dto.CookingIngredientDto;
import com.example.googoos.domain.food.cooking.dto.CookingListDto;
import com.example.googoos.domain.food.cooking.dto.CookingRecipeDto;

import java.util.List;

public interface CookingRepositoryCustom {
    List<CookingListDto> findAllGroupByCategory();

    CookingDetailDto findByIdCustom(Long id);

    List<CookingIngredientDto> findIngredientsById(Long id);

    List<CookingRecipeDto> findRecipeById(Long id);
}
