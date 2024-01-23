export async function fetchFoodCategories() {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/food/categories`);
  if (!res.ok) {
    throw new Error("Failed to fetch food categories");
  }

  return res.json();
}
