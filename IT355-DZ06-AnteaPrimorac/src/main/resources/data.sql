DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255),
    price       DECIMAL(10, 2),
    image_url   VARCHAR(255)
);

-- `order` je rezerviran naziv
CREATE TABLE IF NOT EXISTS orders
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255),
    surname VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS order_product
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id   BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity   INT    NOT NULL,
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (id)
);

INSERT INTO product (name, description, price, image_url)
VALUES ('Enchanted Sword', 'A sword imbued with magical powers.', 150.00, 'https://placehold.co/150x150');
INSERT INTO product (name, description, price, image_url)
VALUES ('Dragon Shield', 'A shield forged from dragon scales.', 200.00, 'https://placehold.co/150x150');
INSERT INTO product (name, description, price, image_url)
VALUES ('Mystic Wand', 'A wand capable of casting spells of great power.', 120.00, 'https://placehold.co/150x150');
INSERT INTO product (name, description, price, image_url)
VALUES ('Elixir of Life', 'A rare potion that grants temporary invulnerability.', 300.00,
        'https://placehold.co/150x150');
INSERT INTO product (name, description, price, image_url)
VALUES ('Cloak of Invisibility', 'A cloak that renders its wearer invisible to the naked eye.', 250.00,
        'https://placehold.co/150x150');
INSERT INTO product (name, description, price, image_url)
VALUES ('Phoenix Feather', 'A magical feather with healing properties.', 100.00, 'https://placehold.co/150x150');
INSERT INTO product (name, description, price, image_url)
VALUES ('Arcane Tome', 'An ancient book filled with magical knowledge.', 400.00, 'https://placehold.co/150x150');
