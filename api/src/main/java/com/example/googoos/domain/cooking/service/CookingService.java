package com.example.googoos.domain.cooking.service;

import com.example.googoos.domain.cooking.dto.CookingDetailDto;
import com.example.googoos.domain.cooking.dto.CookingGenerateDto;
import com.example.googoos.domain.cooking.dto.CookingListDto;
import com.example.googoos.domain.inrgredient.repository.IngredientCategoryRepository;
import com.example.googoos.domain.recipe.dto.RecipeDto;
import com.example.googoos.domain.cooking.entity.Cooking;
import com.example.googoos.domain.cooking.entity.CookingCategory;
import com.example.googoos.domain.recipe.entity.Recipe;
import com.example.googoos.domain.cooking.repository.CookingCategoryRepository;
import com.example.googoos.domain.inrgredient.repository.IngredientRepository;
import com.example.googoos.domain.cooking.repository.CookingRepository;
import com.example.googoos.domain.inrgredient.entity.Ingredient;
import com.example.googoos.domain.inrgredient.entity.IngredientCategory;
import com.example.googoos.domain.recipe.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CookingService {
    private final String url = "https://www.10000recipe.com/recipe";

    private final CookingRepository cookingRepository;
    private final CookingCategoryRepository cookingCategoryRepository;
    private final IngredientCategoryRepository ingredientCategoryRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    public List<CookingListDto> findAll() {
        return cookingRepository.findAllGroupByCategory();
    }

    public CookingDetailDto findById(Long id) {
        return cookingRepository.findByIdCustom(id).orElseThrow(() -> new IllegalArgumentException("요리정보를 찾을수 없습니다."));
    }


    @Transactional
    public void generateRecipe(CookingGenerateDto cookingGenerateDto) {
        String cookingName = cookingGenerateDto.getCookingName();
        cookingRepository.findByCookingName(cookingName).ifPresent(v -> {
            throw new IllegalStateException("이미 존재하는 요리 입니다. 요리명: " + v.getCookingName());
        });

        Document document = null;
        try {
            document = Jsoup.connect(url + "/" + cookingGenerateDto.getRecipeId()).get();
        } catch (IOException e) {
            log.error("요리정보를 가져오는데 실패하였습니다.");
        }

        if (document != null) {
            String categoryName = cookingGenerateDto.getCookingCategoryName();

            // 카테고리가 없다면 카테고리 생성
            CookingCategory cookingCategory = cookingCategoryRepository.findByCategoryName(categoryName)
                    .orElse(cookingCategoryRepository.save(CookingCategory
                            .builder()
                            .categoryName(categoryName)
                            .build())
                    );

            // 요리 생성
            Cooking cooking = cookingRepository.save(Cooking
                    .builder()
                    .cookingName(cookingName)
                    .cookingCategory(cookingCategory)
                    .build()
            );

            // 요리 재료 생성
            List<Ingredient> ingredients = generateIngredients(document, cooking);
            ingredientRepository.saveAll(ingredients);

            // 요리 레시피 생성
            List<Recipe> recipes = generateRecipe(document, cooking);
            recipeRepository.saveAll(recipes);
        }
    }

    private List<Ingredient> generateIngredients(Document document, Cooking cooking) {
        List<Ingredient> cookingIngredients = new ArrayList<>();

        Element ingredientArea = document.getElementById("divConfirmedMaterialArea");
        Elements categories = ingredientArea.getElementsByTag("ul");

        for (Element category : categories) {
            String categoryName = category.getElementsByTag("b").get(0).html()
                    .replace("[", "")
                    .replace("]", "");

            IngredientCategory ingredientCategory = ingredientCategoryRepository.save(IngredientCategory
                    .builder()
                    .categoryName(categoryName)
                    .build()
            );

            Elements ingredients = category.getElementsByTag("li");
            for (Element ingredient : ingredients) {
                String[] splits = ingredient.text().split(" ");

                String ingredientName = splits[0];
                String ingredientUnit = splits[2];


                Ingredient cookingIngredient = Ingredient
                        .builder()
                        .cooking(cooking)
                        .ingredientName(ingredientName)
                        .unit(ingredientUnit)
                        .ingredientCategory(ingredientCategory)
                        .build();

                cookingIngredients.add(cookingIngredient);
            }
        }

        return cookingIngredients;
    }

    private List<Recipe> generateRecipe(Document document, Cooking cooking) {
        List<Recipe> recipes = new ArrayList<>();

        int step = 1;
        Elements elements = document.getElementsByClass("view_step_cont");
        for (Element element : elements) {
            Element recipeEl = element.getElementsByClass("media-body").get(0);
            
            String description = recipeEl.ownText();
            String subDescription = recipeEl.getElementsByClass("add_material").text();

            Recipe recipe = Recipe
                    .builder()
                    .cooking(cooking)
                    .step(step++)
                    .description(description)
                    .subDescription(subDescription)
                    .build();

            recipes.add(recipe);
        }
        return recipes;
    }
}
