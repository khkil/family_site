package com.example.googoos.domain.food.category.repository;

import com.example.googoos.domain.food.category.dto.CookingCategoryDto;


import com.example.googoos.domain.food.category.entity.CookingCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.googoos.domain.food.category.entity.QCookingCategory.cookingCategory;
import static com.example.googoos.domain.food.cooking.entity.QCooking.cooking;

import static com.querydsl.core.group.GroupBy.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CookingCategoryRepositoryImpl implements CookingCategoryRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CookingCategoryDto> findAllCustom() {
        List<CookingCategory> cookingCategories = jpaQueryFactory.selectFrom(cookingCategory).fetch();
        return cookingCategories.stream().map(v -> new CookingCategoryDto(
                v.getCategoryName(),
                v.getCookingList().stream().map(v1 -> new CookingCategoryDto.Cooking(
                        v1.getId(),
                        v1.getCookingName()
                )).toList()
        )).toList();
    }
}
