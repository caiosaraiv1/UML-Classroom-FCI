CREATE DATABASE IF NOT EXISTS sistema_entregas_drones;
USE sistema_entregas_drones;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    endereco VARCHAR(255) NOT NULL
);

CREATE TABLE drones (
    id VARCHAR(50) PRIMARY KEY,
    status_bateria INT NOT NULL,
    capacidade_carga DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL
);

CREATE TABLE pacotes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    peso DECIMAL(10, 2) NOT NULL
);

CREATE TABLE entregas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    destino VARCHAR(255) NOT NULL,
    cliente_id INT NOT NULL,
    pacote_id INT NOT NULL,
    drone_id VARCHAR(50),
    CONSTRAINT fk_entrega_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    CONSTRAINT fk_entrega_pacote FOREIGN KEY (pacote_id) REFERENCES pacotes(id),
    CONSTRAINT fk_entrega_drone FOREIGN KEY (drone_id) REFERENCES drones(id)
);

CREATE TABLE historico_entregas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    entrega_id INT NOT NULL,
    data_hora_registro DATETIME NOT NULL,
    CONSTRAINT fk_historico_entrega FOREIGN KEY (entrega_id) REFERENCES entregas(id)
);