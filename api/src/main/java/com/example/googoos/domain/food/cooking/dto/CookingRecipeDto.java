package com.example.googoos.domain.food.cooking.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class CookingRecipeDto {
    private Long id;
    private Integer step;
    private String description;
    private String notice;

    @QueryProjection
    public CookingRecipeDto(Long id, Integer step, String description, String notice) {
        this.id = id;
        this.step = step;
        this.description = description;
        this.notice = notice;
    }
}
