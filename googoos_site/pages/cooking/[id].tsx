import Layout from "@/components/Layout";
import { List } from "konsta/react";
import { useRouter } from "next/router";

export default function CookingListPage() {
  const router = useRouter();

  return (
    <Layout>
      <List strongIos></List>
    </Layout>
  );
}
