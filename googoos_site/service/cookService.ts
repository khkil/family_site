import { Ingredient, Recipe } from "@/types/foodType";

export async function fetchCookingList() {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/cooking`);
  if (!res.ok) {
    throw new Error("요리 목록을 가져오는데 실패하였습니다.");
  }
  return res.json();
}

export async function fetchCookingDetail(id: number) {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/cooking/${id}`);
  if (!res.ok) {
    throw new Error("요리 상세정보를 가져오는데 실패하였습니다.");
  }
  return res.json();
}

export async function fetchCookingIngredients(id: number) {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/cooking/${id}/ingredients`);
  if (!res.ok) {
    throw new Error("요리 재료 정보를 가져오는데 실패하였습니다.");
  }
  return res.json();
}

export async function fetchCookingRecipe(id: number) {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/cooking/${id}/recipe`);
  if (!res.ok) {
    throw new Error("요리 레시피 정보를 가져오는데 실패하였습니다.");
  }
  return res.json();
}

export async function fetchModifyCooking(id: number, params: { ingredients: Array<Ingredient>; recipes: Array<Recipe> }) {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/cooking/${id}`, {
    method: "PATCH",
    body: JSON.stringify(params),
  });
  if (!res.ok) {
    throw new Error("요리 정보 수정에 실패하였습니다.");
  }
  return res.json();
}
