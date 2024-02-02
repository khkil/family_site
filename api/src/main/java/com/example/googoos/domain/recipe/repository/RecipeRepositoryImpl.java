package com.example.googoos.domain.recipe.repository;

import com.example.googoos.domain.recipe.dto.QRecipeDto;
import com.example.googoos.domain.recipe.dto.RecipeDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.googoos.domain.recipe.entity.QRecipe.recipe;

@RequiredArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<RecipeDto> findByCookingId(Long cookingId) {
        return jpaQueryFactory
                .select(new QRecipeDto(
                        recipe.id,
                        recipe.step,
                        recipe.description,
                        recipe.subDescription
                ))
                .from(recipe)
                .where(recipe.cooking.id.eq(cookingId))
                .orderBy(recipe.step.asc())
                .fetch();
    }
}
