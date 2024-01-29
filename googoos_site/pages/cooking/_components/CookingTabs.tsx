import { Segmented, SegmentedButton } from "konsta/react";
import { useRouter } from "next/router";
import { useMemo } from "react";

interface Props {
  tabIndex: number;
  setTabIndex: (index: number) => void;
}

interface Menu {
  title: string;
}

const CookingDetailMenuTabs = ({ tabIndex, setTabIndex }: Props) => {
  const { asPath, push } = useRouter();
  const tabData: Array<Menu> = useMemo(
    () => [
      {
        title: "재료",
      },
      {
        title: "조리 과정",
      },
    ],
    []
  );

  return (
    <div>
      <Segmented strong>
        {tabData.map(({ title }: Menu, index) => (
          <SegmentedButton key={index} strong active={index === tabIndex} onClick={() => setTabIndex(index)}>
            {title}
          </SegmentedButton>
        ))}
      </Segmented>
    </div>
  );
};

export default CookingDetailMenuTabs;
