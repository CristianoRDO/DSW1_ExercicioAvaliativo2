DROP DATABASE pedidos_db;

CREATE DATABASE pedidos_db;

USE pedidos_db;

CREATE TABLE IF NOT EXISTS tb_user(
	email VARCHAR(60) NOT NULL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    password VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_pedidos (
	id_pedido INT AUTO_INCREMENT PRIMARY KEY,
	name_cliente VARCHAR(150) NOT NULL,
	endereco VARCHAR(200) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
	descricao VARCHAR(300),
    user VARCHAR(60) NOT NULL,
	FOREIGN KEY (user) REFERENCES tb_user(email) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO tb_user (email, name, password) VALUES ('admin@gmail.com', 'admin', 'admin');

SELECT * FROM tb_user;

SELECT * FROM tb_pedidos;
