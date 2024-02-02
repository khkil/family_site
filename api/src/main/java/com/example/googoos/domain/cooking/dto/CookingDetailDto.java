package com.example.googoos.domain.cooking.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CookingDetailDto {
    private Long id;
    private String cookingName;


    @QueryProjection
    public CookingDetailDto(Long id, String cookingName) {
        this.id = id;
        this.cookingName = cookingName;
    }
}
