INSERT INTO shop (shop_id, name) VALUES (1, 'MANGO')
INSERT INTO shop (shop_id, name) VALUES (2, 'CA')

INSERT INTO sender (sender_id, name, authentication_code) VALUES (1, 'first.sender.name', 'codecodecode')
INSERT INTO product_type (product_type_id, name) VALUES (1, 'UNISEX')

INSERT INTO product_category (id, name) VALUES (1, 'Underwear')
INSERT INTO product_category (id, name) VALUES (2, 'Lingerie')
INSERT INTO product_category (id, name) VALUES (3, 'Others')

INSERT INTO product (id, hash, last_update, image_url, price, regular_price, title, shop_id, product_type_id) VALUES (1, 124124, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'img-url', 21.2, 24.2, 'title', 1, 1)
INSERT INTO product (id, hash, last_update, image_url, price, regular_price, title, shop_id, product_type_id) VALUES (2, 124124, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'img-url', 21.2, 24.2, 'to be deleted', 1, 1)