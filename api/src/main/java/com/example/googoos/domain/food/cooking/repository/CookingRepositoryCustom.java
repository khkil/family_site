package com.example.googoos.domain.food.cooking.repository;

import com.example.googoos.domain.food.cooking.dto.CookingDetailDto;
import com.example.googoos.domain.food.cooking.dto.CookingListDto;

import java.util.List;
import java.util.Optional;

public interface CookingRepositoryCustom {
    List<CookingListDto> findAllGroupByCategory();

    Optional<CookingDetailDto> findByIdWithIngredient(Long id);
}
