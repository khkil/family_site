package com.example.googoos.domain.recipe.entity;

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
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer step;

    private String description;

    private String subDescription;

    @ManyToOne
    private Cooking cooking;
}
