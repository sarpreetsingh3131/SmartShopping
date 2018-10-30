CREATE DATABASE users;
CREATE DATABASE carts;

USE users;

CREATE TABLE user (
  id VARCHAR (255) PRIMARY KEY,
  username VARCHAR (255) UNIQUE NOT NULL,
  password VARCHAR (255) NOT NULL,
  deleted BOOLEAN
);

USE carts;

CREATE TABLE cart (
  user_id VARCHAR (255) PRIMARY KEY,
  deleted BOOLEAN
);


CREATE TABLE product (
  barcode VARCHAR (255) PRIMARY KEY,
  name VARCHAR (255) NOT NULL,
  brand VARCHAR (255) NOT NULL,
  quantity VARCHAR (255) NOT NULL,
  user_id VARCHAR(255) NOT NULL,
  deleted BOOLEAN
);

SHOW DATABASES;
