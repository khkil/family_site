package com.example.googoos.domain.recipe.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class RecipeDto {
    private Long id;
    private Integer step;
    private String description;
    private String subDescription;

    @QueryProjection
    public RecipeDto(Long id, Integer step, String description, String subDescription) {
        this.id = id;
        this.step = step;
        this.description = description;
        this.subDescription = subDescription;
    }
}
