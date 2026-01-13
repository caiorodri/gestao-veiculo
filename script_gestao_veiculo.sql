DROP DATABASE gestao_veiculo;
CREATE DATABASE gestao_veiculo;
USE gestao_veiculo;

CREATE TABLE usuario (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    
) ENGINE=InnoDB;

CREATE TABLE marca (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_fipe VARCHAR(20) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL
    
) ENGINE=InnoDB;

CREATE TABLE modelo (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca_id BIGINT NOT NULL,
    codigo_fipe VARCHAR(20) NOT NULL,
    codigo_api VARCHAR(50),
    nome VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    combustivel VARCHAR(50),
    valor_atual DECIMAL(10, 2),
    CONSTRAINT fk_modelo_marca FOREIGN KEY (marca_id) REFERENCES marca(id),
    CONSTRAINT unq_modelo_ano UNIQUE (codigo_fipe, ano)
    
) ENGINE=InnoDB;


CREATE TABLE historico (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    modelo_id BIGINT NOT NULL,
    data_referencia DATE NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_historico_modelo FOREIGN KEY (modelo_id) REFERENCES modelo(id),
    CONSTRAINT unq_historico_modelo_data UNIQUE (modelo_id, data_referencia)
    
) ENGINE=InnoDB;

CREATE TABLE veiculo (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    modelo_id BIGINT NOT NULL,
    apelido VARCHAR(50),
    data_compra DATE NOT NULL,
    valor_compra DECIMAL(10, 2) NOT NULL,
    vendido BOOLEAN DEFAULT FALSE,    
    CONSTRAINT fk_veiculo_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_veiculo_modelo FOREIGN KEY (modelo_id) REFERENCES modelo(id)
    
) ENGINE=InnoDB;

CREATE TABLE indicador (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_referencia DATE NOT NULL UNIQUE,
    ipca DECIMAL(5, 2),
    cdi DECIMAL(5, 2)
    
) ENGINE=InnoDB;