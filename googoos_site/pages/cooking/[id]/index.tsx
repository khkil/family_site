import Layout from "@/components/Layout";
import { fetchCookingDetail } from "@/service/cookService";
import { CookingDetail, Ingredient, IngredientCategory } from "@/types/foodType";
import { BlockTitle, List, ListItem } from "konsta/react";
import { GetServerSideProps } from "next";
import CookingDetailMenuTabs from "../_components/CookingTabs";

interface Props {
  cookingDetail: CookingDetail;
}

export const getServerSideProps: GetServerSideProps<Props> = async (context) => {
  const cookingId = parseInt(context.query?.id as string);

  const { data: cookingDetail } = await fetchCookingDetail(cookingId);
  return {
    props: {
      cookingDetail,
    },
  };
};

export default function CookingDetailPage({ cookingDetail: { id, ingredientCategories } }: Props) {
  return (
    <Layout>
      <CookingDetailMenuTabs id={id} />
      {ingredientCategories.map(({ id, categoryName, ingredients }: IngredientCategory) => (
        <div key={id}>
          <BlockTitle>{categoryName}</BlockTitle>
          <List strong inset>
            {ingredients.map(({ cookingId, ingredientCategoryId, ingredientName, description }: Ingredient) => (
              <ListItem key={`${cookingId}_${ingredientCategoryId}`} title={ingredientName} subtitle={description} />
            ))}
          </List>
        </div>
      ))}
    </Layout>
  );
}
