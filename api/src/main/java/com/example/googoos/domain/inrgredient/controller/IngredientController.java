package com.example.googoos.domain.inrgredient.controller;

import com.example.googoos.common.ApiResponse;
import com.example.googoos.domain.inrgredient.dto.IngredientDto;
import com.example.googoos.domain.inrgredient.service.IngredientService;
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
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping("/ingredients")
    public ResponseEntity<ApiResponse<?>> findIngredientsById(@PathVariable Long cookingId) {
        List<IngredientDto> cookingIngredients = ingredientService.findByCookingId(cookingId);
        return ResponseEntity.ok(ApiResponse.createSuccess(cookingIngredients));
    }
}
