import { create } from "zustand";
import { persist } from "zustand/middleware";

interface State {
  title: string;
  subTitle: string;
  rightIcon?: {
    onClick: () => void;
    title: string;
  };
}

interface Actions {
  setHeader: (state: State) => void;
  resetHeader: () => void;
}

const store: string = "header_store";
const initialState: State = {
  title: "데일리쿡",
  subTitle: "오늘은 뭘먹을까",
};

export const useHeader = create<State & Actions>()(
  persist(
    (set) => ({
      ...initialState,
      setHeader: ({ title, subTitle }: State) => set(() => ({ title, subTitle })),
      resetHeader: () => set(() => initialState),
    }),
    {
      name: store,
    }
  )
);
