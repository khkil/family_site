package com.example.googoos.domain.food.cooking.controller;

import com.example.googoos.common.ApiResponse;
import com.example.googoos.domain.food.cooking.dto.CookingListDto;
import com.example.googoos.domain.food.cooking.service.CookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/cooking")
public class CookingController {
    private final CookingService cookingService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> findAll() {
        List<CookingListDto> cookingCategories = cookingService.findAll();
        return ResponseEntity.ok(ApiResponse.createSuccess(cookingCategories));
    }
}
