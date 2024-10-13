CREATE DATABASE Empresa_Joaquim

CREATE TABLE seccao(
	numsec INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50),
    cidade VARCHAR(50),
    CONSTRAINT PK_SECCAO PRIMARY KEY (numsec)
) AUTO_INCREMENT = 10;

CREATE TABLE empregado(
	numEmp INT NOT NULL AUTO_INCREMENT, 
	nome VARCHAR(50) NOT NULL,
	seccao INT NOT NULL,
    posto VARCHAR(50) NOT NULL,
	chefe INT NULL,
    salario INT NOT NULL,
    comissao INT NOT NULL,
    CONSTRAINT PK_EMPREGADO PRIMARY KEY(numEmp),
    CONSTRAINT FK_EMPREGADO_SECCAO FOREIGN KEY (seccao) REFERENCES seccao(numSec)
);

INSERT INTO seccao (numsec, nome, cidade) VALUES
	(10, "Fabrico", "Porto"),
    (20, "Comercial", "Porto"),
    (30, "Marketing", "Braga"),
    (40, "Planeamento", "Guimarães"),
    (50, "Administração", "Porto"),
    (60, "Informática", "Braga"),
    (70, "Recursos Humanos", "Guimarães");

INSERT INTO empregado(nome, seccao, posto, chefe, salario, comissao) VALUES
("Ana", 10, "Programador", 3, 3000, 10),
("Nuno", 70, "Engenheiro", 1, 1500, 40),
("Álvaro", 50, "Administrador", null, 2500, 0),
('António', 10, 'Engenheiro', null, 2500, 20),
('Susana', 20, 'Administrador', null, 2750, 30),
('Cláudio', 60, 'Vendedor', 4, 1000, 50)

--Atualizar campo de tabela com dados
UPDATE empregado SET chefe = '3' WHERE empregado.numEmp = 4

--PRÁTICA LABORATORIAL 03 --------------------------------------------------------------------------------------------------------------------------------------------------


--EX4-A
select s.nome, s.cidade
FROM seccao s
WHERE s.numsec=70
--R: Seleciona o nome e a cidade da seção com o ID 70 = RH Guimarães

--EX4-B
SELECT e.posto, e.salario, e.comissao
FROM empregado e
WHERE e.comissao>e.salario
--R: Seleciona o posto salario e comissao dos empregados, onde a comissão e superior a salário. Neste caso não retorna nada porque o salário e sempre superior à comissão

--EX4-C
SELECT s.nome
FROM seccao s
WHERE s.cidade like 'Porto'
--R: Seleciona as seções que estão sediadas no Porto, neste caso são 3.

--EX4-D
SELECT e.nome, e.salario, e.comissao
FROM empregado e
WHERE e.salario >= 20*e.comissao OR e.salario=2000
--R: Seleciona todos, porque quase todos os salarios sao maiores que 2000 e os que nao sao o salario e sempre superior à comissao*20

--EX4-E
SELECT DISTINCT e.posto
FROM empregado e
--R: Seleciona os 4 postos diferentes existentes na tabela.

--EX4-F
SELECT e.nome, e.posto, e.salario
FROM empregado e
WHERE e.seccao != 70
ORDER BY e.posto, e.salario DESC
--R: Ordena o nome posto e salario dos empregados, posto ascendente, salario descendente

--EX4-G
SELECT e.nome
FROM empregado e
WHERE e.seccao NOT IN (SELECT s.numsec FROM seccao s WHERE s.cidade like 'Porto');
--R: Seleciona os empregados onde a secção deles não seja sediada no Porto

--EX4-H
SELECT e.nome
FROM empregado e
WHERE e.nome LIKE 'A%a'
--R: Seleciona o empregado que comece por A e acabe em A, e tenha uma letra no meio, neste caso a Ana.

--EX4-I
SELECT e.nome, e.salario, f.nome, f.salario
FROM empregado e, empregado f
WHERE e.chefe = f.numemp and e.salario>f.salario
--R: Seleciona os empregados e respetivos chefes onde os empregados ganhem mais que os chefes, na mesma tabela

--EX4-J
SELECT e.nome
FROM empregado e
WHERE e.seccao != 10 AND e.posto IN (SELECT posto FROM empregado WHERE seccao=10)
--R: Seleciona o empregado com o mesmo posto e uma secção diferente de 10

--EX4-K
SELECT e.nome, f.nome
from empregado e, empregado f 
WHERE e.chefe = f.numEmp and e.salario>=f.salario*2
ORDER BY (e.salario-f.salario) DESC

--EX4-L 
SELECT e.nome, e.posto, e.seccao
FROM empregado e
WHERE e.seccao IN (20,30,40)
--R: Seleciona os empregados cuja seção equivale  a 20, 30 ou 40

--EX4-M 
SELECT s.nome, s.cidade
FROM seccao s, empregado e 
WHERE e.seccao=s.numsec
--r: Tipo inner Join sem ser inner join de nome e cidade

--EX4-N 
SELECT s.nome, s.cidade
FROM seccao s, empregado e 
WHERE e.seccao=s.numsec
--r: Soma de tudo o que os programadores e engenheiros mais um valor qualquer adicionado, anualmente

--EX4-O
SELECT e.seccao, count(e.nome) AS num_emp
FROM empregado e 
GROUP BY e.seccao
--r: agrupar por secção e contar os trabalhadores 

--EX4-P
SELECT SUM(e.salario) AS salario_tot
FROM empregado e 
GROUP BY e.seccao
--r: Somar o total de salários e agrupar por secção

--EX4-Q
SELECT SUM(e.salario) AS salario_tot
FROM empregado e 
GROUP BY e.seccao
--r: Verificar trabalhadores por secção

--EX4-R
SELECT e.posto, AVG(e.salario) AS med_salario
FROM empregado e 
GROUP BY e.posto
--r: Salário médio por posto

--EX4-S
SELECT e.posto, MAX(e.salario) as MAX_SALARIO
FROM empregado e
GROUP BY e.posto
--r: Salário máximo por posto

--EX4-T
SELECT e.posto, COUNT(e.nome) AS NUM_EMP
FROM empregado e 
GROUP BY e.posto 
HAVING COUNT(e.nome)>=2
--r: Verificar quantos postos têm 2 ou mais empregados

--EX4-U
SELECT e.posto, AVG(e.salario) AS MED_SALARIO
FROM empregado e 
GROUP BY e.posto 
HAVING COUNT(e.nome)>=2
--r: Fazer média dos postos que têm dois ou mais trabalhadores



--PRÁTICA LABORATORIAL 04 --------------------------------------------------------------------------------------------------------------------------------------------------

CREATE DATABASE GestComercial_Joaquim

CREATE TABLE Cliente(
	ID INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    morada VARCHAR(250),
    estado BIT,
	CONSTRAINT PK_CLIENTE PRIMARY KEY(ID)
)


CREATE TABLE produto(
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    preco DECIMAL(12,2)
)

CREATE TABLE Venda(
	ID_Produto INT NOT NULL,
    ID_Cliente INT NOT NULL,
	data DATETIME NOT NULL,
    CONSTRAINT PK_VENDA PRIMARY KEY (data, ID_Cliente, ID_Produto),
	CONSTRAINT FK_CLIENTE_VENDA FOREIGN KEY (ID_Cliente) REFERENCES cliente(id),
    CONSTRAINT FK_PRODUTO_VENDA FOREIGN KEY (ID_Produto) REFERENCES produto(id)
)

ALTER TABLE venda ADD COLUMN qtd INT 

INSERT INTO Cliente(nome, morada, estado) VALUES 
('Helena Monteiro', 'Perafita - Freixieiro', 1),
('Raul Simas', 'Palmela', 0)

INSERT INTO Produto(descricao, preco) VALUES 
('Rato Logitec XPTO 1', 10),
('Monitor Sony Vaio XPTO', 120)

INSERT INTO Venda(id_cliente, id_produto, qtd, data) VALUES 
(1, 1, 1, '2012-05-04'),
(2, 1, 5, '2012-05-04')

--PRÁTICA LABORATORIAL 04 - EX4 --------------------------------------------------------------------------------------------------------

--A
UPDATE venda SET qtd=10 WHERE venda.ID_Produto = 1 AND venda.ID_Cliente = 2 AND data = '2012-05-04 00:00:00'

--B
UPDATE Cliente SET morada = 'Porto' WHERE cliente.nome = "Raul Simas"

--C
UPDATE produto SET preco = 100 WHERE descricao LIKE 'monitor%'

