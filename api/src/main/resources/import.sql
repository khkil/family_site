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
-- 제육 볶음 - 레시피
INSERT INTO cooking_recipe(cooking_id, step, description, notice) VALUES (1, 1, '재료를 먹기 좋은 크기로 썰어주세요.', '');
INSERT INTO cooking_recipe(cooking_id, step, description, notice) VALUES (1, 2, '고추장 2스푼, 간장 2스푼. 고춧가루 2스푼, 다진마늘 1스푼, 굴소스 1스푼, 올리고당 1스푼 넣어서 양념장을 만들어주세요.', '');
INSERT INTO cooking_recipe(cooking_id, step, description, notice) VALUES (1, 3, '고기가 익어갈때 설탕을 넣고 더 구워주는게 백종원 제육볶음의 포인트! 동물성 단백질로 구성된 식재료는 설탕부터 사용해야 단맛을 제대로 낼수 있다고해요 소금부터 넣거나 다른 것부터 간을 해버리면 설탕입자는 들어가지 않아서 고기에 단맛이 안베니까 꼭 설탕부터^^ 2스푼 넣었습니다!!! 기호에 따라 가감하시길', '');





/*  요리 - 찌개류*/
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('김치찌개', 1);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('된장찌개', 1);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('순두부찌개', 1);

/* 요리 - 반찬류*/
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('무생채', 2);
INSERT INTO cooking (cooking_name, cooking_category_id) VALUES ('어묵볶음', 2);

