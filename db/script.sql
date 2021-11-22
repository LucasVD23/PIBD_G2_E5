---------------------------------------
-- Eduardo dos Santos Gualberto 769726
-- Lucas Vinícius Domingues 769699
-- Rafael Yoshio Yamawaki Murata 769681
-- Victor Luís Aguilar Antunes 769734
---------------------------------------
ALTER TABLE pessoa ADD qtd_amigos INTEGER DEFAULT 0;
ALTER TABLE pessoa ADD qtd_carros INTEGER DEFAULT 0;

--1. Crie uma sequência para o código da pessoa.
CREATE SEQUENCE IF NOT EXISTS cod_pessoa_seq START 1;

--2/11/12 procedimentos de qtd_amigos e qtd_carros
create or replace function pessoa_qtd_carros_inc_func()
returns trigger language plpgsql as $$ 
begin
	RAISE NOTICE 'NEW: %', NEW;
	UPDATE pessoa SET qtd_carros = qtd_carros + 1
	WHERE pessoa.codigo = NEW.codigopessoa;
	RETURN NEW;
end $$;
create trigger pessoa_qtd_carros_inc_trigger
before insert on possui
for each row execute procedure pessoa_qtd_carros_inc_func();

create or replace function pessoa_qtd_carros_dec_func()
returns trigger language plpgsql as $$ 
begin
	RAISE NOTICE 'OLD: %', OLD;
	UPDATE pessoa SET qtd_carros = qtd_carros - 1
	WHERE pessoa.codigo = OLD.codigopessoa;
	RETURN OLD;
end $$;
create trigger pessoa_qtd_carros_dec_trigger
before delete on possui
for each row execute procedure pessoa_qtd_carros_dec_func();



create or replace function pessoa_qtd_amigos_inc_func()
returns trigger language plpgsql as $$ 
begin
	RAISE NOTICE 'NEW: %', NEW;
	UPDATE pessoa SET qtd_amigos = qtd_amigos + 1
	WHERE pessoa.codigo = NEW.codigo1 OR pessoa.codigo = NEW.codigo2;
	RETURN NEW;
end $$;
create  trigger pessoa_qtd_amigos_inc_trigger
before insert on amizade
for each row execute procedure pessoa_qtd_amigos_inc_func();

create or replace function pessoa_qtd_amigos_dec_func()
returns trigger language plpgsql as $$ 
begin
	RAISE NOTICE 'OLD: %', OLD;
	UPDATE pessoa SET qtd_amigos = qtd_amigos - 1
	WHERE pessoa.codigo = OLD.codigo1 OR pessoa.codigo = OLD.codigo2;
	RETURN OLD;
end $$;
create trigger pessoa_qtd_amigos_dec_trigger
before delete on amizade
for each row execute procedure pessoa_qtd_amigos_dec_func();


--3. Faça uma trigger que use sequências para a inserção das chaves das tuplas de pessoa (disparar antes de inserção na tabela pessoa).
create or replace function pessoa_pk_func()
returns trigger language plpgsql as $$ 
begin
	RAISE NOTICE 'NEW: %', NEW;
	NEW.codigo = nextval('cod_pessoa_seq');
	return new;
end $$;
create trigger pessoa_pk_trigger
before insert on pessoa
for each row execute procedure pessoa_pk_func();

--7. Faça uma função que retorne o nome da pessoa.
CREATE OR REPLACE FUNCTION pessoa_nome(codp INTEGER) RETURNS VARCHAR(50)
	AS '
		SELECT nome 
		FROM pessoa 
		WHERE codigo = codp;
	'
	LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;

--8. Faça uma função que retorne o número de amigos que ela possui.
CREATE OR REPLACE FUNCTION pessoa_nro_amigos(codp INTEGER) RETURNS BIGINT
	AS '
		SELECT count(*) 
		FROM amizade 
		WHERE codigo1 = codp OR codigo2 = codp;
	'
	LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;
	
CREATE OR REPLACE PROCEDURE  inserePessoa(nome IN VARCHAR, data_nasc IN DATE, homepage IN VARCHAR, cep in varchar, numero in Integer
										 ,complemento VARCHAR)
	LANGUAGE SQL
	AS $$
	INSERT INTO Pessoa(nome,data_nascimento, homepage,cep,numero,complemento) VALUES (nome,data_nasc,homepage,cep,numero,complemento);
	
	$$;
	
CREATE OR REPLACE PROCEDURE  insereCarro(placa IN VARCHAR, ano IN INTEGER, cor IN VARCHAR, modelo IN VARCHAR)
	LANGUAGE plpgsql
	AS $$
	declare
		cor_def VARCHAR = 'Branco';
	begin
		if cor is null then
			INSERT INTO Carro(placa,ano, cor,modelo) VALUES (placa,ano,cor_def,modelo);
		else
			INSERT INTO Carro(placa,ano, cor,modelo) VALUES (placa,ano,cor,modelo);
		end if;
	end $$;
	
CREATE OR REPLACE PROCEDURE  insereTelefone(cod_pessoa IN Integer, telefone IN VARCHAR)
	LANGUAGE SQL
	AS $$
	
	INSERT INTO Telefone(codigo_pessoa,telefone) VALUES (cod_pessoa,telefone);
	 $$;	
CREATE OR REPLACE PROCEDURE  inserePossui(cod_pessoa IN INTEGER, placa IN VARCHAR)
	LANGUAGE SQL
	AS $$
	INSERT INTO Possui(codigoPessoa,placa) VALUES (cod_pessoa,placa);
	$$;
	
CREATE OR REPLACE PROCEDURE  insereAmizade(cod1 IN INTEGER, cod2 IN Integer,data_ IN DATE)
	LANGUAGE plpgsql
	AS $$
	declare
		data_def DATE = CURRENT_DATE;
	BEGIN
		if data_ is null then
			INSERT INTO Amizade(codigo1,codigo2, data_inicio) VALUES (cod1,cod2,data_def);
		else
			INSERT INTO Amizade(codigo1,codigo2, data_inicio) VALUES (cod1,cod2,data_);
		end if;
	END $$;
	
CREATE OR REPLACE PROCEDURE  inserePessoa(cod_pessoa IN INTEGER,nome IN VARCHAR, data_nasc IN DATE, homepage IN VARCHAR, cep in varchar, numero in Integer
										 ,complemento VARCHAR)
	LANGUAGE SQL
	AS $$
	UPDATE Pessoa SET nome = nome, data_nascimento = data_nasc,homepage = homepage,
	cep =cep,numero = numero WHERE codigo= cod_pessoa ;
	$$;
CREATE OR REPLACE PROCEDURE  updateCarro(placa IN VARCHAR, ano IN INTEGER, cor IN VARCHAR, modelo IN VARCHAR)
	LANGUAGE SQL
	AS $$
	UPDATE CARRO SET  ano = ano, cor = cor, modelo = modelo WHERE placa = placa;
	$$;
CREATE OR REPLACE PROCEDURE  updateTelefone(cod_pessoa IN Integer, telefone IN VARCHAR)
	LANGUAGE SQL
	AS $$
	UPDATE Telefone SET telefone = telefone WHERE codigo_pessoa =cod_pessoa;
	 $$;	
CREATE OR REPLACE PROCEDURE  updatePossuiporPessoa(cod_pessoa IN INTEGER, placa IN VARCHAR)
	LANGUAGE SQL
	AS $$
	UPDATE Possui SET placa = placa WHERE codigoPessoa = cod_pessoa;
	$$;
CREATE OR REPLACE PROCEDURE  updatePossuiporCarro(cod_pessoa IN INTEGER, placa IN VARCHAR)
	LANGUAGE SQL
	AS $$
	UPDATE Possui SET codigoPessoa = cod_pessoa WHERE placa = placa;
	$$;
CREATE OR REPLACE PROCEDURE  updatePossuiporPessoa(cod_pessoa IN INTEGER, placa IN VARCHAR)
	LANGUAGE SQL
	AS $$
	UPDATE Possui SET placa = placa WHERE codigoPessoa = cod_pessoa;
	$$;
CREATE OR REPLACE PROCEDURE  updateAmizade(cod1 IN INTEGER, cod2 IN Integer,data_ IN DATE)
	LANGUAGE SQL
	AS $$
	UPDATE Amizade SET codigo2 = cod2, data_inicio = data_ WHERE codigo1 =cod1;
	$$;

CREATE OR REPLACE PROCEDURE conta_amigos_proc(codP INTEGER)
LANGUAGE plpgsql
AS $$
BEGIN
	SELECT codigo1 
	FROM amizade
	WHERE codigo1 = codP OR codigo2 = codP;
	if sql%found then
		UPDATE pessoa 
		SET qtd_amigos = sql%rowcount
		WHERE codigo = codP;
	end if;
END $$;

CREATE OR REPLACE PROCEDURE conta_carros_proc(codP INTEGER)
LANGUAGE plpgsql
AS $$
DECLARE
	abc CURSOR (pessoa_cod INTEGER) FOR
	select COUNT(*) as qtd
	from possui
	where pessoa_cod = codigoPessoa;
	
	v_qtd integer;
BEGIN
	open abc(codP);
	fetch abc into v_qtd;
	if abc%found then
		UPDATE pessoa SET qtd_carros = v_qtd 
		WHERE codigo = codP;
	end if;
	close abc;
END $$;

create or replace function qtd_donos_carro(placa VARCHAR(30), ccursor refcursor)
returns integer language plpgsql as $$ 
declare
	v_placa possui.placa%type;
	v_qtd integer;
begin
	fetch ccursor into v_placa, v_qtd;
	while ccursor%found loop
		if v_placa = placa then
			return v_qtd;
		end if;
	end loop;
	return 0;
end $$;

CALL inserePessoa('NomeTeste','23-04-1999','home','2323',7,'comp');
CALL inserePessoa('nome1','23-04-2000','home','23432',1,'complemento');
CALL inserePessoa('nome2','24-04-1993','home22','233432',2,'complemento');
CALL inserePessoa('nome3','12-03-2000','hosssme','243432',3,'complemento');
CALL inserePessoa('nome4', '12-03-2020', 'casa', '243432', 4, 'comp');
CALL inserePessoa('nome5', '12-03-2030', 'casa2', '243423', 5, 'complmt');
CALL inserePessoa('cleitin','23-04-1939','cli.com','7657',43,'comp');
CALL inserePessoa('clodoaldo','23-04-1969','clodo.com','0987',67,'comp');
CALL inserePessoa('NomenovaPesosa','23-04-1994','minhapagina','1123',9,'comp');
CALL inserePessoa('Novonome','13-04-1999','pagina','4523',1,'comp');

CALL InsereCarro('2222',2021,'Vermelho','Jaguar');
CALL InsereCarro('1111',1997,'azul','fusca');
CALL InsereCarro('3333',2022,'Branco','Jaguar');
CALL InsereCarro('4444',2016,'Preto','BMW');
CALL InsereCarro('1234',2001,'Preto','Mercedes');
CALL InsereCarro('1001',2010,'Amarelo','Fiat');
CALL InsereCarro('9999',2014,'Vermelho','Ferrari');
CALL InsereCarro('5555',2000,'Cinza','Kombi');
CALL InsereCarro('6666',2001,'Laranja','celta');
CALL InsereCarro('7777',2002,'Ube','corsa');

CALL InsereTelefone(1,'2323');
CALL InsereTelefone(2, '3124');
CALL InsereTelefone(2, '8578');
CALL InsereTelefone(3, '1209');
CALL InsereTelefone(4, '1299');
CALL InsereTelefone(5, '0972');
CALL InsereTelefone(4,'40028922');
CALL InsereTelefone(5,'41128922');
CALL InsereTelefone(4,'43028922');
CALL InsereTelefone(7,'99999');

Call InserePossui(1,'2222');
Call InserePossui(2,'1111');
Call InserePossui(4,'1111');
Call InserePossui(3,'1001');
Call InserePossui(3,'2222');
Call InserePossui(6,'7777');
Call InserePossui(8,'9999');
Call InserePossui(8,'1234');
Call InserePossui(5,'9999');
Call InserePossui(10,'1001');

Call InsereAmizade(1,2,'12-04-2015');
Call InsereAmizade(2,3,null);
Call InsereAmizade(4,5,null);
Call InsereAmizade(8,9,'05-09-2010');
Call InsereAmizade(1,9,'01-04-1990');
Call InsereAmizade(1,5,'13-04-2015');
Call InsereAmizade(4,10,'11-04-1991');
Call InsereAmizade(2,8,null);
Call InsereAmizade(1,8,'13-04-2015');
Call InsereAmizade(4,3,'11-04-1991');

--13. Faça uma view que retorne todas os nomes das pessoas que não tem amigos.
CREATE OR REPLACE VIEW sem_amigo AS
    SELECT nome
    FROM pessoa
    WHERE qtd_amigos = 0;

--14. Faça uma view que retorne o nome das pessoas que tem o carro modelo ‘Jaguar’ e dos seus amigos.
CREATE OR REPLACE VIEW pessoa_com_jaguar AS
    SELECT j.nome_dono, ps.nome FROM
    (	
    	SELECT p.codigo as cod, p.nome as nome_dono
	    FROM pessoa p JOIN possui t
	    ON p.codigo = t.codigoPessoa 
	    JOIN carro c
	    ON t.placa = c.placa
	    WHERE c.modelo = 'Jaguar'
	) AS j
	JOIN amizade a
	ON j.cod = a.codigo1
	JOIN pessoa ps
	ON ps.codigo = a.codigo2;

CREATE OR REPLACE PROCEDURE tmp()
LANGUAGE plpgsql
AS $$
DECLARE
	ccursor CURSOR FOR SELECT placa, COUNT(*) as qtd FROM possui GROUP BY placa;
	v_tmp INTEGER;
BEGIN
	open ccursor;
	v_tmp := qtd_donos_carro('2222', ccursor);
	RAISE NOTICE 'qtd %', v_tmp;
	close ccursor;
END $$;
