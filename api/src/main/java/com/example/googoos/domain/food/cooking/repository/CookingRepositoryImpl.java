package com.example.googoos.domain.food.cooking.repository;

import com.example.googoos.domain.food.cooking.dto.*;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.googoos.domain.food.cooking.entity.QCookingCategory.cookingCategory;
import static com.example.googoos.domain.food.cooking.entity.QCooking.cooking;
import static com.example.googoos.domain.food.cooking.entity.QCookingCategory.cookingCategory;
import static com.example.googoos.domain.food.cooking.entity.QCookingIngredient.cookingIngredient;
import static com.example.googoos.domain.food.cooking.entity.QIngredientCategory.ingredientCategory;
import static com.querydsl.core.group.GroupBy.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CookingRepositoryImpl implements CookingRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CookingListDto> findAllGroupByCategory() {
        return jpaQueryFactory
                .selectFrom(cooking)
                .leftJoin(cooking.cookingIngredients, cookingIngredient)
                .leftJoin(cookingIngredient.ingredientCategory, ingredientCategory)
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

    @Override
    public Optional<CookingDetailDto> findByIdWithIngredient(Long id) {
        return jpaQueryFactory
                .selectFrom(cooking)
                .leftJoin(cooking.cookingIngredients, cookingIngredient)
                .leftJoin(cookingIngredient.ingredientCategory, ingredientCategory)
                .where(cooking.id.eq(id))
                .transform(groupBy(cooking.id).list(
                        new QCookingDetailDto(
                                cooking.cookingName,
                                set(new QCookingDetailDto_IngredientCategory(
                                        ingredientCategory.categoryName,
                                        list(new QCookingDetailDto_Ingredient(
                                                cookingIngredient.ingredientName,
                                                cookingIngredient.description
                                        ))

                                ))
                        )
                ))
                .stream().findAny();
    }
}
