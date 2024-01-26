package com.example.googoos.domain.food.cooking.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CookingDetailDto {
    private String cookingName;
    private Set<IngredientCategory> ingredientCategories;

    @QueryProjection
    public CookingDetailDto(String cookingName, Set<IngredientCategory> ingredientCategories) {
        this.cookingName = cookingName;
        this.ingredientCategories = ingredientCategories;
    }

    @Data
    public static class IngredientCategory {
        private String categoryName;
        private List<Ingredient> ingredients;

        @QueryProjection
        public IngredientCategory(String categoryName, List<Ingredient> ingredients) {
            this.categoryName = categoryName;
            this.ingredients = ingredients;
        }
    }

    @Data
    public static class Ingredient {
        private String ingredientName;
        private String description;

        @QueryProjection
        public Ingredient(String ingredientName, String description) {
            this.ingredientName = ingredientName;
            this.description = description;
        }
    }
}
