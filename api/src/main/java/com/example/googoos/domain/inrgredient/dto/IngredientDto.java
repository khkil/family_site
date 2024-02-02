package com.example.googoos.domain.inrgredient.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class IngredientDto {
    private Long id;
    private String categoryName;
    private List<IngredientDto.Ingredient> ingredients;

    @QueryProjection
    public IngredientDto(Long id, String categoryName, List<IngredientDto.Ingredient> ingredients) {
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
