package com.example.googoos.domain.food.cooking.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CookingDetailDto {
    private Long id;
    private String cookingName;
    private Set<IngredientCategory> ingredientCategories;


    @QueryProjection
    public CookingDetailDto(Long id, String cookingName, Set<IngredientCategory> ingredientCategories) {
        this.id = id;
        this.cookingName = cookingName;
        this.ingredientCategories = ingredientCategories;
    }

    @Data
    public static class IngredientCategory {
        private Long id;
        private String categoryName;
        private List<Ingredient> ingredients;

        @QueryProjection // Cooking > IngredientCategory mapping
        public IngredientCategory(Long id, String categoryName) {
            this.id = id;
            this.categoryName = categoryName;
        }

        @QueryProjection // IngredientCategory > Ingredient mapping
        public IngredientCategory(Long id, String categoryName, List<Ingredient> ingredients) {
            this.id = id;
            this.categoryName = categoryName;
            this.ingredients = ingredients;
        }
    }

    @Data
    public static class Ingredient {
        private Long cookingId;
        private Long ingredientCategoryId;
        private String ingredientName;
        private String description;

        @QueryProjection
        public Ingredient(Long cookingId, Long ingredientCategoryId, String ingredientName, String description) {
            this.cookingId = cookingId;
            this.ingredientCategoryId = ingredientCategoryId;
            this.ingredientName = ingredientName;
            this.description = description;
        }
    }
}
