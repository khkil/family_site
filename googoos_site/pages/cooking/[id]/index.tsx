import Layout from "@/components/Layout";
import { fetchCookingDetail, fetchCookingIngredients, fetchCookingRecipe } from "@/service/cookService";
import { useHeader } from "@/stores/headerStore";
import { CookingDetail, IngredientCategory, Recipe } from "@/types/foodType";
import { GetServerSideProps } from "next";
import { useEffect, useState } from "react";
import Ingredients from "../_components/CookingIngredients";
import CookingRecipe from "../_components/CookingRecipe";
import CookingDetailMenuTabs from "../_components/CookingTabs";

interface Props {
  cookingDetail: CookingDetail;
  ingredientCategories: Array<IngredientCategory>;
  recipes: Array<Recipe>;
}

export const getServerSideProps: GetServerSideProps<Props> = async (context) => {
  const cookingId = parseInt(context.query?.id as string);

  const [{ data: cookingDetail }, { data: ingredientCategories }, { data: recipes }] = await Promise.all([
    await fetchCookingDetail(cookingId),
    await fetchCookingIngredients(cookingId),
    await fetchCookingRecipe(cookingId),
  ]);
  return {
    props: {
      cookingDetail,
      ingredientCategories,
      recipes,
    },
  };
};

export default function CookingDetailPage({ cookingDetail: { id, cookingName }, ingredientCategories, recipes }: Props) {
  const { setHeader, resetHeader } = useHeader();
  const [tabIndex, setTabIndex] = useState<number>(0);

  useEffect(() => {
    setHeader({ title: cookingName, subTitle: "재료 / 조리과정" });
    return () => {
      resetHeader();
    };
  }, []);

  return (
    <Layout>
      <CookingDetailMenuTabs tabIndex={tabIndex} setTabIndex={setTabIndex} />
      {tabIndex === 0 ? <Ingredients ingredientCategories={ingredientCategories} /> : <CookingRecipe recipes={recipes} />}
    </Layout>
  );
}
