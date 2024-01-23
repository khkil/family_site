"use client";
import Layout from "@/app/_components/Layout";
import { fetchFoodCategories } from "@/app/_service/cookService";
import { List, ListGroup, ListItem } from "konsta/react";

async function FoodCategories() {
  const foodCategories = await fetchFoodCategories();

  return foodCategories.map((play) => (
    <ListGroup>
      <ListItem title={play.categoryName} groupTitle contacts />
      {play.cookingList.map((cooking) => (
        <ListItem title={cooking.cookingName} contacts />
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
