package com.example.googoos.domain.food.cooking.service;

import com.example.googoos.domain.food.cooking.dto.CookingDetailDto;
import com.example.googoos.domain.food.cooking.dto.CookingIngredientDto;
import com.example.googoos.domain.food.cooking.dto.CookingListDto;
import com.example.googoos.domain.food.cooking.repository.CookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CookingService {
    private final CookingRepository cookingRepository;

    public List<CookingListDto> findAll() {
        return cookingRepository.findAllGroupByCategory();
    }

    public CookingDetailDto findById(Long id) {
        return cookingRepository.findByIdCustom(id);
    }

    public List<CookingIngredientDto> findIngredientsById(Long id) {
        return cookingRepository.findIngredientsById(id);
    }
}
