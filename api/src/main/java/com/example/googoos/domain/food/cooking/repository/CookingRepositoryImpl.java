package com.example.googoos.domain.food.cooking.repository;

import com.example.googoos.domain.food.cooking.dto.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.example.googoos.domain.food.cooking.entity.QCooking.cooking;
import static com.example.googoos.domain.food.cooking.entity.QCookingCategory.cookingCategory;
import static com.example.googoos.domain.food.cooking.entity.QCookingIngredient.cookingIngredient;
import static com.example.googoos.domain.food.cooking.entity.QIngredientCategory.ingredientCategory;
import static com.example.googoos.domain.food.cooking.entity.QCookingRecipe.cookingRecipe;
import static com.querydsl.core.group.GroupBy.*;

@RequiredArgsConstructor
public class CookingRepositoryImpl implements CookingRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CookingListDto> findAllGroupByCategory() {
        return jpaQueryFactory
                .selectFrom(cooking)
                .leftJoin(cooking.cookingCategory, cookingCategory)
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
    public CookingDetailDto findByIdCustom(Long id) {
        return jpaQueryFactory
                .selectFrom(cooking)
                .where(cooking.id.eq(id))
                .transform(groupBy(cooking.id).list(
                        new QCookingDetailDto(
                                cooking.id,
                                cooking.cookingName
                        )
                ))
                .stream().findAny().orElse(null);
    }

    @Override
    public List<CookingIngredientDto> findIngredientsById(Long id) {
        return jpaQueryFactory
                .selectFrom(cookingIngredient)
                .leftJoin(cookingIngredient.ingredientCategory, ingredientCategory)
                .where(cooking.id.eq(id))
                .transform(groupBy(ingredientCategory.id).list(
                        new QCookingIngredientDto(
                                ingredientCategory.id,
                                ingredientCategory.categoryName,
                                list(new QCookingIngredientDto_Ingredient(
                                        cookingIngredient.id,
                                        cookingIngredient.ingredientName,
                                        cookingIngredient.description
                                ))
                        )
                ));
    }

    @Override
    public List<CookingRecipeDto> findRecipeById(Long id) {
        return jpaQueryFactory
                .select(new QCookingRecipeDto(
                        cookingRecipe.id,
                        cookingRecipe.step,
                        cookingRecipe.description,
                        cookingRecipe.notice
                ))
                .from(cookingRecipe)
                .where(cookingRecipe.cooking.id.eq(id))
                .orderBy(cookingRecipe.step.asc())
                .fetch();
    }
}
