import { Recipe } from "@/types/foodType";
import { ReactElement } from "react";

interface Props {
  recipes: Array<Recipe>;
}
export default function CookingRecipe({ recipes }: Props): ReactElement {
  return <>레시피</>;
}
