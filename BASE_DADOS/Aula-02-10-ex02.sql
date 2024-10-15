CREATE DATABASE Empresa_Fabio;

USE Empresa_Fabio;

CREATE TABLE seccao
(
    numSec INT         NOT NULL AUTO_INCREMENT,
    nome   VARCHAR(30) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    CONSTRAINT PK_SECCAO
        PRIMARY KEY (numSec)
) AUTO_INCREMENT = 10;

CREATE TABLE empregado
(
    numEmp   INT         NOT NULL AUTO_INCREMENT,
    nome     VARCHAR(30) NOT NULL,
    posto    VARCHAR(30) NOT NULL,
    seccao   INT         NOT NULL,
    chefe    INT         NULL,
    salario  INT         NOT NULL,
    comissao INT         NOT NULL,
    CONSTRAINT PK_EMPREGADO
        PRIMARY KEY (numEmp),
    CONSTRAINT FK_EMPREGADO_SECCAO
        FOREIGN KEY (seccao)
            REFERENCES seccao (numSec)
);

INSERT INTO seccao(nome, cidade)
VALUES ('Fabrico', 'Porto'),
       ('Comercial', 'Porto'),
       ('Marketing', 'Braga'),
       ('Planeamento', 'Guimarães'),
       ('Administração', 'Porto'),
       ('Informática', 'Braga'),
       ('Recursos Humanos', 'Guimarães');

INSERT INTO empregado(nome, seccao, posto, chefe, salario, comissao)
VALUES ('Ana', 10, 'Programador', 3, 3000, 10),
       ('Nuno', 70, 'Engenheiro', 1, 1500, 40),
       ('Álvaro', 50, 'Administrador', null, 2500, 0),
       ('António', 10, 'Engenheiro', 3, 2500, 20),
       ('Susana', 20, 'Administrador', null, 2750, 30),
       ('Cláudio', 60, 'Vendedor', 4, 1000, 50);

select e.nome, e.salario, e.comissao
  from empregado e
 where e.salario >= 20 * e.comissao
    or e.salario = 2000;

select distinct e.posto
  from empregado e;

select e.nome, e.posto, e.salario
  from empregado e
 where e.seccao != 70
 order by e.posto, e.salario desc;

select e.nome
  from empregado e
 where e.seccao not in (select s.numsec
                          from seccao s
                         where s.cidade like 'Porto');

select e.nome
  from empregado e
 where e.nome like 'A%a';

select e.nome, e.salario, f.nome, f.salario
  from empregado e,
       empregado f
 where e.chefe = f.numemp
   and e.salario > f.salario;

select e.nome
  from empregado e
 where e.seccao != 10
   and e.posto in (select posto from empregado where seccao = 10)

select e.nome, f.nome
  from empregado e,
       empregado f
 where e.chefe = f.numemp
   and e.salario >= f.salario * 2
 order by (e.salario - f.salario) desc

