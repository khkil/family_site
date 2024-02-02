package com.example.googoos.domain.inrgredient.repository;

import com.example.googoos.domain.inrgredient.dto.IngredientDto;
import com.example.googoos.domain.inrgredient.dto.QIngredientDto;
import com.example.googoos.domain.inrgredient.dto.QIngredientDto_Ingredient;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.googoos.domain.cooking.entity.QCooking.cooking;
import static com.example.googoos.domain.inrgredient.entity.QIngredient.ingredient;
import static com.example.googoos.domain.inrgredient.entity.QIngredientCategory.ingredientCategory;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@RequiredArgsConstructor
public class IngredientRepositoryImpl implements IngredientRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<IngredientDto> findByCookingId(Long cookingId) {
        return jpaQueryFactory
                .selectFrom(ingredient)
                .leftJoin(ingredient.ingredientCategory, ingredientCategory)
                .where(cooking.id.eq(cookingId))
                .transform(groupBy(ingredientCategory.id).list(
                        new QIngredientDto(
                                ingredientCategory.id,
                                ingredientCategory.categoryName,
                                list(new QIngredientDto_Ingredient(
                                        ingredient.id,
                                        ingredient.ingredientName,
                                        ingredient.unit
                                ))
                        )
                ));
    }
}