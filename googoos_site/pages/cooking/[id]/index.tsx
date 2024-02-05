import Header from "@/components/Header";
import LayerPopup from "@/components/LayerPopup";
import Layout from "@/components/Layout";
import { fetchCookingDetail, fetchCookingIngredients, fetchCookingRecipe } from "@/service/cookService";
import { CookingDetail, IngredientCategory, Recipe } from "@/types/foodType";
import { GetServerSideProps } from "next";
import { useState } from "react";
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
  const [tabIndex, setTabIndex] = useState<number>(0);
  const [canModify, setCanModify] = useState<boolean>(false);
  const [openedModifyPopup, setOpenedModifyPopup] = useState<boolean>(false);

  return (
    <Layout>
      <Header
        title={cookingName}
        subTitle={!canModify ? "재료 및 조리과정" : "내용 수정"}
        leftIcon={
          !canModify
            ? undefined
            : {
                title: "취소",
                onClick: () => setCanModify(false),
              }
        }
        rightIcon={{
          title: !canModify ? "수정" : "완료",
          onClick: () => (!canModify ? setCanModify(true) : setOpenedModifyPopup(true)),
        }}
      />
      <CookingDetailMenuTabs tabIndex={tabIndex} setTabIndex={setTabIndex} />
      {tabIndex === 0 ? <Ingredients ingredientCategories={ingredientCategories} canModify={canModify} /> : <CookingRecipe recipes={recipes} />}
      <LayerPopup opened={openedModifyPopup} setOpened={setOpenedModifyPopup} onClick={() => alert(1)} />
    </Layout>
  );
}
