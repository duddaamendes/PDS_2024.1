DROP DATABASE IF EXISTS BDV;

CREATE DATABASE IF NOT EXISTS BDV;
USE `BDV` ;

CREATE TABLE IF NOT EXISTS `viagens` (
  `id_viagem` INT(7) NOT NULL auto_increment,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `destino` VARCHAR(100) NOT NULL,
  `dataInicio` DATE NOT NULL,
  `dataTermino` DATE NOT NULL,
  `atividades` VARCHAR(100) NOT NULL,
  `orcamento` INT(20) NOT NULL,
  `doc` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_viagem`));
  
insert into viagens (nome, email, telefone, destino, dataInicio, dataTermino, atividades, orcamento, doc) values ('Berkley Kelston', 'bkelston0@unesco.org', '2796928713', 'Thailand', '2023-04-20', '2025-01-01', 'King Mongkut''s University of Technology Thonburi', 674, '46054189699');
insert into viagens (nome, email, telefone, destino, dataInicio, dataTermino, atividades, orcamento, doc) values ('Dianemarie Damp', 'ddamp1@google.cn', '995161161', 'Brazil', '2023-03-09', '2024-11-11', 'Universidade Estadual de Santa Cruz', 245, 35849990475);
insert into viagens (nome, email, telefone, destino, dataInicio, dataTermino, atividades, orcamento, doc) values ('Alwyn Kleisle', 'akleisle2@independent.co.uk', '7975165223', 'Brazil', '2023-08-29', '2024-11-16', 'Universidade de Pernambuco', 801, 83257334422);
insert into viagens (nome, email, telefone, destino, dataInicio, dataTermino, atividades, orcamento, doc) values ('Betty Roocroft', 'broocroft3@un.org', '1604595993', 'Mongolia', '2023-09-17', '2024-04-26', 'Orkhon University', 572, 37033415961);

select * from viagens;