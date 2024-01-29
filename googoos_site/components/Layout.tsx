import { App, Page } from "konsta/react";
import { ReactNode } from "react";
import Header from "./Header";

const Layout = ({ children }: { children: ReactNode }) => {
  return (
    <App theme="ios">
      <Page>
        <Header />
        {children}
      </Page>
    </App>
  );
};

export default Layout;
