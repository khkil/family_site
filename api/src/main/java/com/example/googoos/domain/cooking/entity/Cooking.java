package com.example.googoos.domain.cooking.entity;

import com.example.googoos.domain.inrgredient.entity.Ingredient;
import com.example.googoos.domain.recipe.entity.Recipe;
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

    @OneToMany(mappedBy = "cooking", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "cooking", cascade = CascadeType.ALL)
    private List<Recipe> recipes;
}
