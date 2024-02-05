import { App, KonstaProvider, Page } from "konsta/react";
import { ReactNode } from "react";

export default function Layout({ children }: { children: ReactNode }) {
  return (
    <KonstaProvider theme="ios">
      <App theme="ios" className="ios">
        <Page>{children}</Page>
      </App>
    </KonstaProvider>
  );
}
