import { Segmented, SegmentedButton } from "konsta/react";

interface Props {
  tabIndex: number;
  setTabIndex: (index: number) => void;
}

interface Menu {
  title: string;
}

const tabData: Array<Menu> = [
  {
    title: "재료",
  },
  {
    title: "조리 과정",
  },
];

const CookingDetailMenuTabs = ({ tabIndex, setTabIndex }: Props) => {
  const handleChange = (index: number) => {
    setTabIndex(index);
  };
  return (
    <div className="h-12">
      <Segmented strong>
        {tabData.map(({ title }: Menu, index) => (
          <SegmentedButton className="h-full" key={index} strong active={index === tabIndex} onClick={() => handleChange(index)}>
            {title}
          </SegmentedButton>
        ))}
      </Segmented>
    </div>
  );
};

export default CookingDetailMenuTabs;
