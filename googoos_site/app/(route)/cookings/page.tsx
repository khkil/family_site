"use client";
import Layout from "@/app/_components/Layout";
import { fetchFoodCategories } from "@/app/_service/cookService";
import { Cooking, CookingCategory } from "@/app/_types/foodType";
import { List, ListGroup, ListItem } from "konsta/react";
import { useRouter } from "next/navigation";
import { Key } from "react";

async function FoodCategories() {
  const router = useRouter();
  const foodCategories = await fetchFoodCategories();

  const moveDetailPage = (id: Number) => {
    router.push(`/cookings/${id}`);
  };

  return foodCategories.map(({ categoryName, cookingList }: CookingCategory, index: Key) => (
    <ListGroup key={index}>
      <ListItem title={categoryName} groupTitle contacts />
      {cookingList.map(({ id, cookingName }: Cooking) => (
        <ListItem key={id} title={cookingName} contacts link onClick={() => moveDetailPage(id)} />
      ))}
    </ListGroup>
  ));
}

export default async function CookingListPage() {
  return (
    <Layout>
      <List strongIos>
        <FoodCategories />
      </List>
    </Layout>
  );
}
