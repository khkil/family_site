--  요리 분류
INSERT INTO cooking_category (id, category_name) VALUES (1, '반찬류');
INSERT INTO cooking_category (id, category_name) VALUES (2, '찌개류');
INSERT INTO cooking_category (id, category_name) VALUES (3, '고기류');

-- 재료 분류
INSERT INTO ingredient_category (id, category_name) VALUES (1, '재료');
INSERT INTO ingredient_category (id, category_name) VALUES (2, '양념');
INSERT INTO ingredient_category (id, category_name) VALUES (3, '조리도구');

-- 제육 볶음
INSERT INTO cooking (id, cooking_name, cooking_category_id) VALUES (1, '제육볶음', 3);
-- 제육 볶음 - 재료
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (1, 1, '돼지고기', '600g');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (1, 1, '양파', '1개');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (1, 1, '청양고추', '2개');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (1, 1, '대파', '1뿌리');
-- 제육 볶음 - 조미료
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (2, 1, '설탕', '2스푼');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (2, 1, '고추장', '2스푼');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (2, 1, '간장', '2스푼');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (2, 1, '고춧가루', '2스푼');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (2, 1, '다진마늘', '1스푼');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (2, 1, '굴소스', '1스푼');
INSERT INTO cooking_ingredient (ingredient_category_id, cooking_id, ingredient_name, description) VALUES (2, 1, '올리고당', '1스푼');
-- 제육 볶음 - 요리 과정

/*  요리 - 찌개류*/
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('김치찌개', 1);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('된장찌개', 1);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('순두부찌개', 1);

/* 요리 - 반찬류*/
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('무생채', 2);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('어묵볶음', 2);

