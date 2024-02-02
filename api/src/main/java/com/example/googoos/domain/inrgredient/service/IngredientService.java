package com.example.googoos.domain.inrgredient.service;

import com.example.googoos.domain.inrgredient.dto.IngredientDto;
import com.example.googoos.domain.inrgredient.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public List<IngredientDto> findByCookingId(Long cookingId) {
        return ingredientRepository.findByCookingId(cookingId);
    }
}
