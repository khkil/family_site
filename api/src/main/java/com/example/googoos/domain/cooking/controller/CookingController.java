package com.example.googoos.domain.cooking.controller;

import com.example.googoos.common.ApiResponse;
import com.example.googoos.domain.cooking.dto.CookingDetailDto;
import com.example.googoos.domain.cooking.dto.CookingGenerateDto;
import com.example.googoos.domain.cooking.dto.CookingListDto;
import com.example.googoos.domain.cooking.dto.CookingRequestDto;
import com.example.googoos.domain.cooking.entity.Cooking;
import com.example.googoos.domain.recipe.dto.RecipeDto;
import com.example.googoos.domain.cooking.service.CookingService;
import com.example.googoos.domain.inrgredient.dto.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cooking")
public class CookingController {
    private final CookingService cookingService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> findAll() {
        List<CookingListDto> cookingCategories = cookingService.findAll();
        return ResponseEntity.ok(ApiResponse.createSuccess(cookingCategories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findById(@PathVariable Long id) {
        CookingDetailDto cookingDetail = cookingService.findById(id);
        return ResponseEntity.ok(ApiResponse.createSuccess(cookingDetail));
    }

    @PostMapping("/generate-cooking")
    public ResponseEntity<ApiResponse<?>> generateRecipe(@RequestBody CookingGenerateDto generateDto) {
        cookingService.generateRecipe(generateDto);
        return ResponseEntity.ok(ApiResponse.createSuccessWithNoContent());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> generateRecipe(@PathVariable Long id, @RequestBody CookingRequestDto params) {
        cookingService.updateById(id, params);
        return ResponseEntity.ok(ApiResponse.createSuccessWithNoContent());
    }
}
