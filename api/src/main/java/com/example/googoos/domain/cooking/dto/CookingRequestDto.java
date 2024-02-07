package com.example.googoos.domain.cooking.dto;

import com.example.googoos.domain.inrgredient.dto.IngredientDto;
import com.example.googoos.domain.recipe.dto.RecipeDto;
import lombok.Data;

import java.util.List;

@Data
public class CookingRequestDto {
    private Long id;
    private List<IngredientDto.Ingredient> ingredients;
    private List<RecipeDto> recipes;
}
