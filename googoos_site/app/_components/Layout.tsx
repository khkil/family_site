import { App } from "konsta/react";
import { ReactNode } from "react";
import Header from "./Header";

const Layout = ({ children }: { children: ReactNode }) => {
  return (
    <App theme="ios">
      <Header />
      {children}
    </App>
  );
};

export default Layout;
