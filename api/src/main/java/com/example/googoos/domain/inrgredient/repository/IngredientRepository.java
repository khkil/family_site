package com.example.googoos.domain.inrgredient.repository;

import com.example.googoos.domain.inrgredient.entity.Ingredient;
import com.example.googoos.domain.recipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>, IngredientRepositoryCustom {
}