"use client";
import Layout from "@/app/_components/Layout";
import { Block, BlockTitle, Button, List, ListItem, Page } from "konsta/react";

export default function Home() {
  return (
    <Layout>
      <Page>
        <Block strong>
          <p>Here is your Next.js & Konsta UI app. Let's see what we have here.</p>
        </Block>
        <BlockTitle>요리 레시피</BlockTitle>
        <List>
          <ListItem href="/about/" title="About" />
          <ListItem href="/form/" title="Form" />
        </List>

        <Block strong className="flex space-x-4">
          <Button>Button 1</Button>
          <Button>Button 2</Button>
        </Block>
      </Page>
    </Layout>
  );
}
