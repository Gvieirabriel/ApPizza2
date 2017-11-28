create database Pizzaria;

use Pizzaria;

create table Cliente(
	idCLiente int not null auto_increment,
	nome varchar(50) not null,
    sobrenome varchar(50) not null,
    telefone int(10),
    primary key(idCliente)
    
);

create table Tipo(
	idTipo int not null auto_increment,
    valorCmQuadrado float,
	tipo varchar(50),
    primary key(idTipo)
);

create table Sabor(
	idSabor int not null auto_increment,
	nome varchar(40),
    codTipo int not null,
    foreign key (codTipo) references Tipo(idTipo),
    primary key(idSabor)
);

create table Forma(
	idForma int not null auto_increment,
	nomeForma varchar(20),
    codSabor int not null,
    dimensaoLado float,
    foreign key (codSabor) references Sabor(idSabor),
    primary key(idForma)
);

create table Pedido(
	idPedido int not null auto_increment,
    valorTotal float,
    codCliente int not null,
    estado varchar(20),
	foreign key (codCliente) references Cliente(idCLiente),
	primary key(idPedido)
);

create table ItemPedido(
	idItemPedido int not null auto_increment,
    valorUnitario double,
    codPedido int not null,
    codForma int not null,
	primary key(idItemPedido),
    foreign key (codPedido) references Pedido(idPedido),
    foreign key (codForma) references Forma(idForma)
);
