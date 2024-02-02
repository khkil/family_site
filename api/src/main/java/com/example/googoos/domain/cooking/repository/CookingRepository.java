package com.example.googoos.domain.cooking.repository;

import com.example.googoos.domain.cooking.entity.Cooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CookingRepository extends JpaRepository<Cooking, Long>, CookingRepositoryCustom {
    Optional<Cooking> findByCookingName(String cookingName);
}


