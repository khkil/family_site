export async function fetchCookingCategories() {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/food/cooking`);
  if (!res.ok) {
    throw new Error("Failed to fetch food categories");
  }
  return res.json();
}
