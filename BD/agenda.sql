create database agenda;
use agenda;

create table aluno(
nome varchar(500),
Cpf char(14),
Email varchar(100),
telefone char(14),
matricula varchar(30),
primary key(Cpf)
);

create table professor(
nome varchar(500),
Cpf char(14),
Email varchar(100),
telefone char(14),
primary key(Cpf)
);

create table curso(
id_curso int,
nome_curso varchar(100),
primary key(id_curso)
);
-- drop database agenda;
