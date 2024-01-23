package com.example.googoos.domain.food.category.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CookingCategoryDto {
    private String categoryName;
    private List<Cooking> cookingList;

    @Data
    @AllArgsConstructor
    public static class Cooking {
        private Long id;
        private String cookingName;
    }
}
