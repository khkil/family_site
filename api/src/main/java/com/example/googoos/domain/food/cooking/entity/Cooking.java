package com.example.googoos.domain.food.cooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cookingName;

    @ManyToOne
    private CookingCategory cookingCategory;

    @OneToMany
    private List<CookingIngredient> cookingIngredients;
}
