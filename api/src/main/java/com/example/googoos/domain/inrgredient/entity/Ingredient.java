package com.example.googoos.domain.inrgredient.entity;

import com.example.googoos.domain.cooking.entity.Cooking;
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
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingredientName;

    private String unit;

    @ManyToOne
    private IngredientCategory ingredientCategory;

    @ManyToOne
    private Cooking cooking;
}
