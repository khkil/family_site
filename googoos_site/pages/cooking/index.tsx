import Layout from "@/components/Layout";
import { fetchCookingCategories } from "@/service/cookService";
import { Cooking, CookingCategory } from "@/types/foodType";
import { searchFirstLetter } from "@/utils/stringUtil";
import { List, ListGroup, ListItem, Searchbar } from "konsta/react";
import { useRouter } from "next/navigation";
import { Key, useMemo, useState } from "react";

interface CategoryProps {
  cookingCategories: Array<CookingCategory>;
}

interface CookingProps {
  cookingList: Array<Cooking>;
}

export const getServerSideProps = async () => {
  const { data: cookingCategories } = await fetchCookingCategories();
  return {
    props: {
      cookingCategories,
    },
  };
};

const CookingList = ({ cookingList }: CookingProps) => {
  const router = useRouter();

  return cookingList.map(({ id, cookingName }: Cooking) => (
    <ListItem key={id} title={cookingName} contacts link onClick={() => router.push(`/cooking/${id}`)} />
  ));
};

export default function CookingListPage({ cookingCategories }: CategoryProps) {
  const [searchText, setSearchText] = useState<string>("");

  const filteredCookingList: Array<CookingCategory> = useMemo(
    () =>
      cookingCategories
        .map(({ cookingList, ...props }: CookingCategory) => ({
          ...props,
          cookingList: cookingList.filter(({ cookingName }: Cooking) => searchFirstLetter(cookingName, searchText)),
        }))
        .filter(({ cookingList }: CookingCategory) => cookingList.length > 0),
    [searchText]
  );

  const notFound: Boolean = useMemo(
    () => filteredCookingList.filter(({ cookingList }: CookingCategory) => cookingList.length > 0).length === 0,
    [filteredCookingList]
  );

  return (
    <Layout>
      <div className="mt-5">
        <Searchbar
          placeholder={"검색"}
          onInput={(e) => {
            setSearchText(e.target.value);
          }}
          value={searchText}
          onClear={() => {
            setSearchText("");
          }}
        />
      </div>
      <List strongIos>
        {notFound ? (
          <ListItem title="검색결과를 찾을수 없습니다." className="text-center" />
        ) : (
          filteredCookingList.map(({ categoryName, cookingList }: CookingCategory, index: Key) => (
            <ListGroup key={index}>
              <ListItem title={categoryName} groupTitle contacts />
              <CookingList cookingList={cookingList} />
            </ListGroup>
          ))
        )}
      </List>
    </Layout>
  );
}
