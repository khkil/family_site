import { Ingredient, IngredientCategory } from "@/types/foodType";
import { BlockTitle, List, ListInput, ListItem } from "konsta/react";
import { ReactElement } from "react";

interface Props {
  ingredientCategories: Array<IngredientCategory>;
  canModify: boolean;
}

const Ingredients = ({ ingredientCategories, canModify }: Props): ReactElement => {
  return (
    <div>
      {ingredientCategories?.map(({ id, categoryName, ingredients }: IngredientCategory) => (
        <div key={id}>
          <BlockTitle>{categoryName}</BlockTitle>
          {!canModify ? (
            <List strong inset>
              {ingredients.map(({ id, ingredientName, description }: Ingredient) =>
                !canModify ? <ListItem key={`${id}`} title={ingredientName} subtitle={description} /> : <IngredientInput />
              )}
            </List>
          ) : (
            ingredients.map((ingredient: Ingredient) => <IngredientInput {...ingredient} />)
          )}
        </div>
      ))}
    </div>
  );
};

const IngredientInput = ({ id, ingredientName, description }: Ingredient) => {
  return (
    <List strongIos insetIos>
      <ListInput type="text" placeholder="재료명" value={ingredientName} />
      <ListInput type="text" placeholder="양" value={description} />
    </List>
  );
};

export default Ingredients;
