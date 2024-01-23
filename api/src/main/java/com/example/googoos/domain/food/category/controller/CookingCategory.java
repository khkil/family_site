package com.example.googoos.domain.food.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/food/categories")
public class CookingCategory {
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok("test");
    }
}
