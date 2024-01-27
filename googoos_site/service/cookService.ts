export async function fetchCookingList() {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/food/cooking`);
  if (!res.ok) {
    throw new Error("요리 목록을 가져오는데 실패하였습니다.");
  }
  return res.json();
}

export async function fetchCookingDetail(id: number) {
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/food/cooking/${id}`);
  if (!res.ok) {
    throw new Error("Failed to fetch food categories");
  }
  return res.json();
}
