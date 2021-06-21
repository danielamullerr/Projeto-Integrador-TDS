create database FromGuri;
use FromGuri;

create table Cadastro (
nome varchar(40) not null,
cpf varchar(15) not null,
datanasc date not null,
senha varchar(15) not null,
email varchar(40) not null,
rua varchar(40) not null,
numero int not null,
cidade varchar(40) not null,
uf varchar(2) not null,
primary key (cpf)
);

create table Produtos (
id_produto int auto_increment,
titulo varchar (20) not null,
descricao varchar(1000) not null,
cep varchar(11) not null,
id_categoria int,
primary key (id_produto),
foreign key (id_categoria) references Categoria (id)
);

create table Categoria (
id int auto_increment,
categoria varchar(20) not null,
primary key (id)
);

insert into Cadastro (nome, cpf, datanasc, senha, email, rua, numero, cidade, uf) values 
('Bruno Almeida', '037.458.274-43', '1993-10-27', '12345678', 'brunoalmeida@gmail.com', 'Rua Osvaldo Aranha', '164', 'Canoas', 'RS'), 
('Daniela Müller', '024.573.997-12', '2000-06-04', '12345678', 'danielamuller@hotmail.com', 'Av. Dom João Becker', '301', 'São Leopoldo', 'RS'), 
('Henrique Oliveira', '854.863.991-34', '1999-02-21', '12345678', 'henriqueoliv@gmail.com', 'Rua Brasil', '2351', 'São Paulo', 'SP');

insert into Produtos (id_categoria, titulo, descricao, cep) values 
(1, 'Tela S10 Quebrada', 'Tela de celular quebrada modelo S10 Samsung', '940.67-123'),
(1, 'Computador Estragado', 'Computador estragado modelo Dell Inspirion', '345.21-435'),
(2, 'Janela Quebrada', 'Janela de madeira quebrada', '653.34-765');


insert into Categoria (categoria) values ('Informática'), ('Reforma'), ('Saúde e Beleza');