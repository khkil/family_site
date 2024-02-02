package com.example.googoos.domain.recipe.repository;

import com.example.googoos.domain.recipe.dto.RecipeDto;

import java.util.List;

public interface RecipeRepositoryCustom {
    List<RecipeDto> findByCookingId(Long cookingId);
}
