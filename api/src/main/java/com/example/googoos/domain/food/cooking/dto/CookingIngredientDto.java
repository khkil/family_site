package com.example.googoos.domain.food.cooking.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class CookingIngredientDto {
    private Long id;
    private String categoryName;
    private List<CookingIngredientDto.Ingredient> ingredients;

    @QueryProjection
    public CookingIngredientDto(Long id, String categoryName, List<CookingIngredientDto.Ingredient> ingredients) {
        this.id = id;
        this.categoryName = categoryName;
        this.ingredients = ingredients;
    }

    @Data
    public static class Ingredient {
        private Long id;
        private String ingredientName;
        private String description;

        @QueryProjection
        public Ingredient(Long id, String ingredientName, String description) {
            this.id = id;
            this.ingredientName = ingredientName;
            this.description = description;
        }
    }
}
