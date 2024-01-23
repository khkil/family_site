"use client";
import Layout from "@/app/_components/Layout";
import { List, ListGroup, ListItem } from "konsta/react";

export default function Home() {
  return (
    <Layout>
      <List strongIos>
        <ListGroup>
          <ListItem title="A" groupTitle contacts />
          <ListItem title="Aaron" contacts />
          <ListItem title="Abbie" contacts />
          <ListItem title="Adam" contacts />
          <ListItem title="Adele" contacts />
          <ListItem title="Agatha" contacts />
          <ListItem title="Agnes" contacts />
          <ListItem title="Albert" contacts />
          <ListItem title="Alexander" contacts />
        </ListGroup>
      </List>
    </Layout>
  );
}
