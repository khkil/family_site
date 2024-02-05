import Header from "@/components/Header";
import Layout from "@/components/Layout";
import { BlockTitle, List, ListItem } from "konsta/react";
import { useRouter } from "next/navigation";

export default function Home() {
  const router = useRouter();
  return (
    <Layout>
      <Header title={process.env.NEXT_PUBLIC_SITE_TITLE} subTitle={process.env.NEXT_PUBLIC_SITE_SUB_TITLE} />
      <BlockTitle>기능 목록</BlockTitle>
      <List strongIos outlineIos>
        <ListItem title="요리 레시피" link onClick={() => router.push("/cooking")} />
      </List>
    </Layout>
  );
}
