CREATE DATABASE agenda_telefonica;
USING DATABASE agenda_telefonica;

DROP TABLE IF EXISTS Possui;
DROP TABLE IF EXISTS amizade;
DROP TABLE IF EXISTS Telefone;
DROP TABLE IF EXISTS Pessoa;
DROP TABLE IF EXISTS Carro;

CREATE TABLE  pessoa
(
    codigo SERIAL,
    nome VARCHAR (50) NOT NULL,
    data_nascimento DATE NOT NULL,
    homepage VARCHAR (50),
    cep VARCHAR (15) NOT NULL,
    numero INTEGER NOT NULL,
    complemento VARCHAR(60),
	CONSTRAINT pessoa_pk PRIMARY KEY (codigo)
);

CREATE TABLE  carro
(
    placa VARCHAR(30) NOT NULL,
    ano INTEGER NOT NULL,
    cor VARCHAR(15) DEFAULT 'Branco', 
    modelo VARCHAR(15) NOT NULL,
    CONSTRAINT carro_pk PRIMARY KEY(placa)
);

CREATE TABLE telefone 
(
    codigo_pessoa INTEGER,
    telefone VARCHAR (15) NOT NULL,
    CONSTRAINT telefone_pk PRIMARY KEY (codigo_pessoa, telefone),
    CONSTRAINT pessoa_fk FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
	ON DELETE CASCADE
);

CREATE TABLE possui 
(
    codigoPessoa INTEGER,
    placa VARCHAR (30),
    CONSTRAINT possui_pk PRIMARY KEY (codigoPessoa, placa),
    CONSTRAINT carro_fk FOREIGN KEY (placa) 
		REFERENCES carro(placa) ON DELETE CASCADE,
    CONSTRAINT pessoa_fk FOREIGN KEY(codigoPessoa)
		REFERENCES pessoa(codigo) ON DELETE CASCADE
);

CREATE TABLE amizade
(
    codigo1 INTEGER,
    codigo2 INTEGER,
    data_inicio DATE DEFAULT CURRENT_DATE,
    CONSTRAINT amizade_pk PRIMARY KEY (codigo1, codigo2),
    CONSTRAINT pessoa1_fk FOREIGN KEY (codigo1)
        REFERENCES pessoa(codigo) ON DELETE NO ACTION,
    CONSTRAINT pessoa2_fk FOREIGN KEY (codigo2)
        REFERENCES pessoa(codigo) ON DELETE NO ACTION
);



