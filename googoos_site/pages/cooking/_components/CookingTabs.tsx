import { Tabbar, TabbarLink } from "konsta/react";

interface Props {
  id: Number;
}

const CookingDetailMenuTabs = ({ id }: Props) => {
  return (
    <Tabbar className="left-0 bottom-0 fixed">
      <TabbarLink active={true} onClick={() => {}} label={"재료"} />
      <TabbarLink active={true} onClick={() => {}} label={"조리 과정"} />
    </Tabbar>
  );
};

export default CookingDetailMenuTabs;
