create database GestComercial_Fabio;

use GestComercial_Fabio;

create table cliente
(
    id     int auto_increment,
    nome   VARCHAR(50) not null,
    morada varchar(250),
    estado bit,
    constraint PK_CLIENTE
        PRIMARY KEY (id)
);

create table produto
(
    id        int          not null auto_increment,
    descricao varchar(100) not null,
    preco     decimal(10, 2),
    constraint PK_PRODUTO
        primary key (id)
);

create table venda
(
    idProduto int not null,
    idCliente int not null,
    data      datetime,
    qtd       int,
    CONSTRAINT PK_VENDA
        PRIMARY KEY (idProduto, idCliente, data),
    CONSTRAINT FK_VENDA_PRODUTO
        FOREIGN KEY (idProduto)
            REFERENCES produto (id),
    CONSTRAINT FK_VENDA_CLIENT
        FOREIGN KEY (idCliente)
            REFERENCES cliente (id)
);

insert into cliente(nome, morada)
values ('Helena Monteiro', 'Perafita – Freixieiro'),
       ('Raul Simas', 'Palmela');

insert into produto(descricao, preco)
values ('Rato Logitec XPTO 1', 10),
       ('Monitor Sony Vaio XPTO', 120);

insert into venda(idproduto, idcliente, data, qtd)
values (1, 1, '2012-05-04 12:00', 1),
       (1, 2, '2012-05-04 14:00', 5);

update venda
   set qtd = 10
 where idProduto = 1
   and idCliente = 2
   and data = '2012-05-04 14:00';

update cliente
   set morada = 'Porto'
 where nome = 'Raul Simas';

update produto
   set preco = 100
 where descricao like 'Monitor%';


# ------- PRÁTICA LABORATORIAL 04 - EX5 --------------------------------------------------------------------------------------------------------

# A
SELECT *
  FROM produto;

# B
SELECT nome
  FROM cliente
 WHERE estado = 1;

# C
SELECT v.*, c.nome
  FROM venda v
           INNER JOIN cliente AS c ON v.idCliente = c.ID
 WHERE c.nome = 'Raul Simas';

# D
SELECT v.*, c.nome
  FROM venda v
           INNER JOIN cliente AS c ON v.idCliente = c.ID
 WHERE c.nome LIKE 'H%';

# E
SELECT COUNT(*)
  FROM venda v
           INNER JOIN cliente AS c ON v.idCliente = c.ID
 WHERE c.nome = 'Raul Simas';

# F
SELECT MAX(preco)
  FROM produto;

# G
SELECT *
  FROM produto
 WHERE preco <= 100;

# H
SELECT *
  FROM cliente
 WHERE ID NOT IN (SELECT DISTINCT idCliente FROM venda);

# I
SELECT venda.data, SUM(venda.qtd * produto.preco)
  FROM venda
           INNER JOIN produto
                      ON venda.idProduto = produto.ID
 GROUP BY venda.data