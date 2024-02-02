package com.example.googoos.domain.cooking.dto;

import lombok.Data;

@Data
public class CookingGenerateDto {
    private Long recipeId;
    private String cookingCategoryName;
    private String cookingName;
}
