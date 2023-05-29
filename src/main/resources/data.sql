CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customers (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE orders (
    id BIGINT NOT NULL AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE deliveries (
    id BIGINT NOT NULL AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    delivery_date TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

-- Inserção de usuários
INSERT INTO users (login, password) VALUES
    ('usuario1', 'senha1'),
    ('usuario2', 'senha2');

-- Inserção de clientes
INSERT INTO customers (name, email, phone) VALUES
    ('Cliente 1', 'cliente1@example.com', '1234567890'),
    ('Cliente 2', 'cliente2@example.com', '9876543210');

-- Inserção de pedidos
INSERT INTO orders (customer_id, order_date, total_amount) VALUES
    (1, '2023-05-28 10:00:00', 50.00),
    (2, '2023-05-29 12:30:00', 80.00);

-- Inserção de entregas
INSERT INTO deliveries (order_id, delivery_date, status) VALUES
    (1, '2023-05-28 14:00:00', 'Em andamento'),
    (2, '2023-05-29 15:00:00', 'Entregue');
