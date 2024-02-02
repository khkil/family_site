package com.example.googoos.domain.recipe.service;

import com.example.googoos.domain.recipe.dto.RecipeDto;
import com.example.googoos.domain.recipe.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public List<RecipeDto> findByCookingId(Long id) {
        return recipeRepository.findByCookingId(id);
    }
}
