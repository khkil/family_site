package com.example.googoos.domain.inrgredient.repository;

import com.example.googoos.domain.inrgredient.dto.IngredientDto;

import java.util.List;

public interface IngredientRepositoryCustom {
    List<IngredientDto> findByCookingId(Long cookingId);
}