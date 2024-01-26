package com.example.googoos.domain.food.cooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CookingIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingredientName;

    private String description;

    @ManyToOne
    private IngredientCategory ingredientCategory;

    @ManyToOne
    private Cooking cooking;
}