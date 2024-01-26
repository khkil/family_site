package com.example.googoos.domain.food.cooking.repository;

import com.example.googoos.domain.food.cooking.dto.CookingListDto;


import com.example.googoos.domain.food.cooking.dto.QCookingListDto;
import com.example.googoos.domain.food.cooking.dto.QCookingListDto_Cooking;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.googoos.domain.food.cooking.entity.QCookingCategory.cookingCategory;
import static com.example.googoos.domain.food.cooking.entity.QCooking.cooking;

import static com.querydsl.core.group.GroupBy.*;

import java.util.List;

@RequiredArgsConstructor
public class CookingRepositoryImpl implements CookingRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CookingListDto> findAllGroupByCategory() {
        return jpaQueryFactory
                .selectFrom(cookingCategory)
                .leftJoin(cookingCategory.cookingList, cooking)
                .orderBy(cookingCategory.categoryName.asc(), cooking.cookingName.asc())
                .transform(groupBy(cookingCategory.id).list(
                        new QCookingListDto(cookingCategory.categoryName,
                                list(new QCookingListDto_Cooking(
                                        cooking.id,
                                        cooking.cookingName
                                ))
                        )
                ));
    }
}
