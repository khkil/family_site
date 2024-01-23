package com.example.googoos.domain.food.category.service;

import com.example.googoos.domain.food.category.dto.CookingCategoryDto;
import com.example.googoos.domain.food.category.repository.CookingCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CookingCategoryService {
    private final CookingCategoryRepository cookingCategoryRepository;

    public List<CookingCategoryDto> findAll() {
        return cookingCategoryRepository.findAllCustom();
    }
}
