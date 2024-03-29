import { Recipe } from "@/types/foodType";
import { BlockTitle, Card } from "konsta/react";
import { ReactElement } from "react";

interface Props {
  recipes: Array<Recipe>;
}
export default function CookingRecipe({ recipes }: Props): ReactElement {
  return (
    <div>
      <BlockTitle withBlock={false}>조리과정</BlockTitle>
      {recipes?.map(({ id, step, description, subDescription }: Recipe) => (
        <Card key={id} footer={subDescription} outline>
          {`${step}. ${description}`}
        </Card>
      ))}
    </div>
  );
}
