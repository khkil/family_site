package com.example.googoos.domain.food.category.repository;

import com.example.googoos.domain.food.category.dto.CookingCategoryDto;


import com.example.googoos.domain.food.category.dto.QCookingCategoryDto;
import com.example.googoos.domain.food.category.dto.QCookingCategoryDto_Cooking;
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
        return jpaQueryFactory
                .selectFrom(cookingCategory)
                .leftJoin(cookingCategory.cookingList, cooking)
                .orderBy(cookingCategory.categoryName.asc(), cooking.cookingName.asc())
                .transform(groupBy(cookingCategory.id).list(
                        new QCookingCategoryDto(cookingCategory.categoryName, list(new QCookingCategoryDto_Cooking(
                                cooking.id,
                                cooking.cookingName
                        )))
                ));
    }
}
