/* 요리 분류 */
INSERT INTO cooking_category (category_name) VALUES ('찌개');
INSERT INTO cooking_category (category_name) VALUES ('반찬');
INSERT INTO cooking_category (category_name) VALUES ('고기');

/*찌개류*/
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('김치찌개', 1);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('된장찌개', 1);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('순두부찌개', 1);

/*반찬류*/
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('무생채', 2);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('어묵볶음', 2);

/*고기류*/
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('제육볶음', 3);