export declare interface Cooking {
  id: number;
  cookingName: string;
}

export declare interface CookingCategory {
  id: number;
  categoryName: string;
  cookingList: Array<Cooking>;
}

export declare interface CookingDetail {
  id: number;
  cookingName: string;
  ingredientCategories: Array<IngredientCategory>;
}

export declare interface IngredientCategory {
  id: number;
  categoryName: string;
  ingredients: Array<Ingredient>;
}

export declare interface Ingredient {
  cookingId: number;
  ingredientCategoryId: number;
  ingredientName: string;
  description: string;
}
