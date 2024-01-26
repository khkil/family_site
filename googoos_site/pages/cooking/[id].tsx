import Layout from "@/components/Layout";
import { BlockTitle, List, ListItem } from "konsta/react";
import { useRouter } from "next/router";

export default function CookingListPage() {
  const router = useRouter();

  return (
    <Layout>
      <BlockTitle>Strong Inset List</BlockTitle>
      <List strong inset>
        <ListItem title="Item 1" />
        <ListItem title="Item 2" />
        <ListItem title="Item 3" />
      </List>
    </Layout>
  );
}
