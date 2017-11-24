create database Pizzaria;

use Pizzaria;

create table Cliente(
	idCLiente int not null auto_increment,
	nome varchar(50) not null,
    sobrenome varchar(50) not null,
    telefone int(10),
    primary key(idCliente)
    
);

create table Sabor(
	idSabor int not null auto_increment,
	nome varchar(40),
    primary key(idSabor)
);

create table Tipo(
	idTipo int not null auto_increment,
	tipo varchar(50),
    primary key(idTipo)
);

create table Forma(
	idForma int not null auto_increment,
	nomeForma varchar(20),
    dimensaoLado float,
    primary key(idForma)
);

create table Pedido(
	idPedido int not null auto_increment,
    valorTotal float,
    estado varchar(20),
	primary key(idPedido)
);

create table ItemPedido(
	idItemPedido int not null auto_increment,
    valorUnitario double,
    codPedido int not null,
    codCliente int not null,
    codForma int not null,
	primary key(idItemPedido),
    foreign key (codPedido) references Pedido(idPedido),
    foreign key (codCliente) references Cliente(idCLiente),
    foreign key (codForma) references Forma(idForma)
);

create table SaboresItemPedido(
	idSaboresItemPedido int not null auto_increment,
	codSabor int,
    codItemPedido int,
    primary key(idSaboresItemPedido),
    foreign key (codSabor) references Sabor(idSabor),
	foreign key (codItemPedido) references ItemPedido(idItemPedido)
);

create table TiposItemPedido(
	idTiposItemPedido int not null auto_increment,
	codTipo int,
    codItemPedido int,
    primary key(idTiposItemPedido),
    foreign key (codTipo) references Tipo(idTipo),
	foreign key (codItemPedido) references ItemPedido(idItemPedido)
);
