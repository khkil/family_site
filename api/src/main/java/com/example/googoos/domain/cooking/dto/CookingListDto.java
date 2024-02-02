package com.example.googoos.domain.cooking.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class CookingListDto {
    private String categoryName;
    private List<Cooking> cookingList;

    @QueryProjection
    public CookingListDto(String categoryName, List<Cooking> cookingList) {
        this.categoryName = categoryName;
        this.cookingList = cookingList;
    }

    @Data
    public static class Cooking {
        private Long id;
        private String cookingName;

        @QueryProjection
        public Cooking(Long id, String cookingName) {
            this.id = id;
            this.cookingName = cookingName;
        }
    }
}
