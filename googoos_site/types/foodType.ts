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
}

export declare interface IngredientCategory {
  id: number;
  categoryName: string;
  ingredients: Array<Ingredient>;
}

export declare interface Ingredient {
  id: number;
  ingredientName: string;
  unit: string;
}

export declare interface Recipe {
  id: number;
  step: number;
  description: string;
  subDescription: string;
}
