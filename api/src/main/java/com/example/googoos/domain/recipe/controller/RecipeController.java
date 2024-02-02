package com.example.googoos.domain.recipe.controller;

import com.example.googoos.common.ApiResponse;
import com.example.googoos.domain.recipe.dto.RecipeDto;
import com.example.googoos.domain.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cooking/{cookingId}")
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recipe")
    public ResponseEntity<ApiResponse<?>> findRecipeById(@PathVariable Long cookingId) {
        List<RecipeDto> cookingRecipe = recipeService.findByCookingId(cookingId);
        return ResponseEntity.ok(ApiResponse.createSuccess(cookingRecipe));
    }
}
