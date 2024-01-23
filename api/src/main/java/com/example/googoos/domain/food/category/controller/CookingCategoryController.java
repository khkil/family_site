package com.example.googoos.domain.food.category.controller;

import com.example.googoos.domain.food.category.dto.CookingCategoryDto;
import com.example.googoos.domain.food.category.service.CookingCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/categories")
public class CookingCategoryController {
    private final CookingCategoryService cookingCategoryService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3099")
    public ResponseEntity<?> findAll() {
        List<CookingCategoryDto> cookingCategories = cookingCategoryService.findAll();
        return ResponseEntity.ok(cookingCategories);
    }
}
