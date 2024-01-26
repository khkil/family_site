package com.example.googoos.domain.food.cooking.repository;

import com.example.googoos.domain.food.cooking.dto.CookingListDto;

import java.util.List;

public interface CookingRepositoryCustom {
    List<CookingListDto> findAllGroupByCategory();
}
