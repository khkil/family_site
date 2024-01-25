import Layout from "@/components/Layout";
import { fetchCookingCategories } from "@/service/cookService";
import { Cooking, CookingCategory } from "@/types/foodType";
import { List, ListGroup, ListItem } from "konsta/react";
import Link from "next/link";
import { useRouter } from "next/router";
import { Key } from "react";

interface Props {
  cookingCategories: Array<CookingCategory>;
}

export const getServerSideProps = async () => {
  const cookingCategories = await fetchCookingCategories();
  return {
    props: {
      cookingCategories,
    },
  };
};

export default function CookingListPage({ cookingCategories }: Props) {
  const router = useRouter();

  return (
    <Layout>
      <List strongIos>
        {cookingCategories.map(({ categoryName, cookingList }: CookingCategory, index: Key) => (
          <ListGroup key={index}>
            <ListItem title={categoryName} groupTitle contacts />
            {cookingList.map(({ id, cookingName }: Cooking) => (
              <Link href={`/cookings/${id}`}>
                <ListItem key={id} title={cookingName} contacts link />
              </Link>
            ))}
          </ListGroup>
        ))}
      </List>
    </Layout>
  );
}
