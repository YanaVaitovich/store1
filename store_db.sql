CREATE DATABASE store;

USE store;

CREATE TABLE users(
id INT AUTO_INCREMENT,
surname VARCHAR(50) NOT NULL,
name VARCHAR(50) NOT NULL,
patronymic VARCHAR(50) NOT NULL,
address VARCHAR(50) NOT NULL,
email VARCHAR(50) UNIQUE NOT NULL,
phone VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(50) NOT NULL,
role VARCHAR(50) NOT NULL,
registrationDate DATE NOT NULL,
inBlackList BOOLEAN,
PRIMARY KEY(id)
);

CREATE TABLE products(
id INT AUTO_INCREMENT,
price INT NOT NULL,
oldPrice INT NOT NULL,
title VARCHAR(50) NOT NULL,
code VARCHAR(50) NOT NULL,
characteristics VARCHAR(255) NOT NULL,
brand VARCHAR(50) NOT NULL,
creatiom_date DATE NOT NULL,
description VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);

 CREATE TABLE orders(
id INT AUTO_INCREMENT,
user_id INT UNIQUE NOT NULL,
address VARCHAR(50)  NOT NULL,
phone VARCHAR(50) NOT NULL,
comment VARCHAR(50)  NOT NULL,
status VARCHAR(50)  NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(user_id) REFERENCES users(id),
FOREIGN KEY(product_id) REFERENCES products(id)
);

CREATE TABLE orders_products(
product_id INT UNIQUE NOT NULL,
order_id INT UNIQUE NOT NULL,
PRIMARY KEY(product_id, order_id),
FOREIGN KEY(product_id) REFERENCES products(id),
FOREIGN KEY(order_id) REFERENCES orders(id)
);

INSERT INTO users (surname, name, patronymic, address, email, phone, password, role, registrationDate, inBlackList) VALUES ('Ivanov', 'Ivan', 'Ivanovich', 'Minsk', 'ivanov@gmail.com', '12345', '12345', 'customer', '2019-12-10', false);
INSERT INTO users (surname, name, patronymic, address, email, phone, password, role, registrationDate, inBlackList) VALUES ('Petov', 'Petrov', 'Petrovich', 'Gomel', 'petrov@gmail.com', '123456', '12345', 'customer', '2019-10-15', false);
INSERT INTO users (surname, name, patronymic, address, email, phone, password, role, registrationDate, inBlackList) VALUES ('Vasiliev', 'Vasily', 'Vasilievich', 'Minsk', 'vasya@gmail.com', '3457685', '12345', 'manager', '2019-09-18', false);

INSERT INTO products (price, oldPrice, title, code, characteristics, brand, creatiom_date, description)  VALUES (1, 2, 'Chocolate', 771676, 'dark chocolate', 'Nestle', '2020-12-12', 'CPFC');
INSERT INTO products (price, oldPrice, title, code, characteristics, brand, creatiom_date, description) VALUES (2, 3, 'Snickers', 771476, 'chocolate', 'Mars', '2020-10-08', 'CPFC');
INSERT INTO products (price, oldPrice, title, code, characteristics, brand, creatiom_date, description) VALUES (1, 2, 'Chocolate', 755346, 'milk chocolate', 'Kommunarka', '2020-09-12', 'CPFC');