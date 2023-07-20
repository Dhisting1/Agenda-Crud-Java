create database agenda;

create table contato(
    id int not null auto_increment,
    nome varchar(255) not null,
    telefone varchar(255) not null,
    email varchar(255) not null,
    cpf varchar(255) not null,
    idade int not null,
    primary key(id)
);
