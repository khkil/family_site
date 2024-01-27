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
    public CookingDetailDto findByIdWithIngredient(Long id) {
        CookingDetailDto cookingDetail = jpaQueryFactory
                .selectFrom(cooking)
                .leftJoin(cooking.cookingIngredients, cookingIngredient)
                .leftJoin(cookingIngredient.ingredientCategory, ingredientCategory)
                .where(cooking.id.eq(id))
                .transform(groupBy(cooking.id).list(
                        new QCookingDetailDto(
                                cooking.id,
                                cooking.cookingName,
                                set(new QCookingDetailDto_IngredientCategory(
                                        ingredientCategory.id,
                                        ingredientCategory.categoryName
                                ))
                        )
                ))
                .stream().findAny().orElse(null);

        if (cookingDetail == null) return null;

        List<CookingDetailDto.Ingredient> ingredients = jpaQueryFactory
                .select(new QCookingDetailDto_Ingredient(
                        cooking.id,
                        ingredientCategory.id,
                        cookingIngredient.ingredientName,
                        cookingIngredient.description
                ))
                .from(cookingIngredient)
                .leftJoin(cookingIngredient.cooking, cooking)
                .leftJoin(cookingIngredient.ingredientCategory, ingredientCategory)
                .where(cooking.id.eq(id))
                .fetch();

        Set<CookingDetailDto.IngredientCategory> ingredientCategories = cookingDetail.getIngredientCategories();
        ingredientCategories.forEach(
                category -> category.setIngredients(
                        ingredients.stream().filter(ingredient ->
                                Objects.equals(id, ingredient.getCookingId()) &&
                                        Objects.equals(category.getId(), ingredient.getIngredientCategoryId())
                        ).toList()
                )
        );

        return cookingDetail;
    }
}
