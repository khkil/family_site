package com.example.googoos.domain.cooking.repository;

import com.example.googoos.domain.cooking.dto.CookingDetailDto;
import com.example.googoos.domain.inrgredient.dto.IngredientDto;
import com.example.googoos.domain.cooking.dto.CookingListDto;
import com.example.googoos.domain.recipe.dto.RecipeDto;

import java.util.List;
import java.util.Optional;

public interface CookingRepositoryCustom {
    List<CookingListDto> findAllGroupByCategory();

    Optional<CookingDetailDto> findByIdCustom(Long id);
}
