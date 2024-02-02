package com.example.googoos.domain.recipe.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class RecipeDto {
    private Long id;
    private Integer step;
    private String description;
    private String notice;

    @QueryProjection
    public RecipeDto(Long id, Integer step, String description, String notice) {
        this.id = id;
        this.step = step;
        this.description = description;
        this.notice = notice;
    }
}
