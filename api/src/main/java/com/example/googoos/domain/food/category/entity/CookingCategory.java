package com.example.googoos.domain.food.category.entity;

import com.example.googoos.domain.food.cooking.entity.Cooking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CookingCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "cookingCategory")
    List<Cooking> cookingList;
}
