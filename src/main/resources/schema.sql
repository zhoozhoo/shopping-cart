DROP TABLE products IF EXISTS;

CREATE TABLE products (
id INTEGER IDENTITY PRIMARY KEY,
name VARCHAR(255) NOT NULL,
price FLOAT NOT NULL
);