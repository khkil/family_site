import { Ingredient, IngredientCategory } from "@/types/foodType";
import { BlockTitle, List, ListItem } from "konsta/react";
import { ReactElement } from "react";

interface Props {
  ingredientCategories: Array<IngredientCategory>;
}

const Ingredients = ({ ingredientCategories }: Props): ReactElement => {
  return (
    <div>
      {ingredientCategories.map(({ id, categoryName, ingredients }: IngredientCategory) => (
        <div key={id}>
          <BlockTitle>{categoryName}</BlockTitle>
          <List strong inset>
            {ingredients.map(({ id, ingredientName, description }: Ingredient) => (
              <ListItem key={`${id}`} title={ingredientName} subtitle={description} />
            ))}
          </List>
        </div>
      ))}
    </div>
  );
};

export default Ingredients;
