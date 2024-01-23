package com.example.googoos.domain.food.cooking.entity;

import com.example.googoos.domain.food.category.entity.CookingCategory;
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
public class Cooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cookingName;

    @ManyToOne
    CookingCategory cookingCategory;
}
