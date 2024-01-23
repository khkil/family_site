"use client";
import Layout from "@/app/_components/Layout";
import { BlockTitle, List, ListItem } from "konsta/react";
import { useRouter } from "next/navigation";

export default function Home() {
  const router = useRouter();
  return (
    <Layout>
      <BlockTitle>기능 목록</BlockTitle>
      <List strongIos outlineIos>
        <ListItem title="요리 레시피" link onClick={() => router.push("/cookings")} />
      </List>
    </Layout>
  );
}
