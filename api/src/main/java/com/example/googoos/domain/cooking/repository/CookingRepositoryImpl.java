package com.example.googoos.domain.cooking.repository;

import com.example.googoos.domain.cooking.dto.*;
import com.example.googoos.domain.inrgredient.dto.QIngredientDto;
import com.example.googoos.domain.inrgredient.dto.QIngredientDto_Ingredient;
import com.example.googoos.domain.recipe.dto.QRecipeDto;
import com.example.googoos.domain.recipe.dto.RecipeDto;
import com.example.googoos.domain.inrgredient.dto.IngredientDto;
import com.example.googoos.domain.recipe.entity.QRecipe;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.example.googoos.domain.cooking.entity.QCooking.cooking;
import static com.example.googoos.domain.cooking.entity.QCookingCategory.cookingCategory;
import static com.example.googoos.domain.inrgredient.entity.QIngredient.ingredient;
import static com.example.googoos.domain.inrgredient.entity.QIngredientCategory.ingredientCategory;
import static com.example.googoos.domain.recipe.entity.QRecipe.recipe;
import static com.querydsl.core.group.GroupBy.*;

@RequiredArgsConstructor
public class CookingRepositoryImpl implements CookingRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CookingListDto> findAllGroupByCategory() {
        return jpaQueryFactory
                .selectFrom(cooking)
                .leftJoin(cooking.cookingCategory, cookingCategory)
                .orderBy(cookingCategory.categoryName.asc(),
                        cooking.cookingName.asc()
                )
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
    public Optional<CookingDetailDto> findByIdCustom(Long id) {
        return jpaQueryFactory
                .selectFrom(cooking)
                .where(cooking.id.eq(id))
                .transform(groupBy(cooking.id).list(
                        new QCookingDetailDto(
                                cooking.id,
                                cooking.cookingName
                        )
                ))
                .stream()
                .findAny();
    }

    @Override
    public void updateById(Long id, CookingRequestDto params) {
        List<IngredientDto.Ingredient> ingredients = params.getIngredients();
        List<RecipeDto> recipes = params.getRecipes();

        ingredients.forEach(v -> jpaQueryFactory.update(ingredient)
                .set(ingredient.ingredientName, v.getIngredientName())
                .set(ingredient.unit, v.getUnit())
                .where(ingredient.cooking.id.eq(id))
                .execute()
        );

        recipes.forEach(v -> jpaQueryFactory.update(recipe)
                .set(recipe.description, v.getDescription())
                .set(recipe.subDescription, v.getSubDescription())
                .where(recipe.cooking.id.eq(id))
                .execute()
        );
    }
}
