show databases;
drop database if exists db_OurBank;
create database db_OurBank;
use db_OurBank;
show tables;

create table tb_uf(
id_uf           int primary key auto_increment,
estado          varchar(25),
sigla           char(2)
);

create table tb_cliente(
id_cliente           int primary key auto_increment,
nome                 varchar(50) not null,
sobrenome			 varchar(50) not null,
cpf                  varchar(11) unique,
data_nasc            date
);

create table tb_endereco(
id_endereco           int primary key auto_increment,
cep                   varchar(8) not null,
logradouro            varchar(60) not null,
complemento			  varchar(200),
bairro                varchar(60) not null,
cidade				  varchar(60) not null,
fk_id_uf              int,
fk_id_cliente 		  int,
foreign key(fk_id_uf) references tb_uf(id_uf),
foreign key(fk_id_cliente) references tb_cliente(id_cliente)
);

create table tb_conta(
id_conta           int primary key auto_increment,
num_conta          varchar(16),
cod_banco          varchar(20),
agencia            varchar(4),
saldo              decimal(10.2),
fk_id_cliente      int,
foreign key(fk_id_cliente) references tb_cliente(id_cliente)
);


create table tb_cartao(
id_cartao           int primary key auto_increment,
num_cartao          int(20),
data_validade       date,
cvc                 varchar(3),
aproximacao         boolean,
ativo               boolean,
fk_id_conta         int,
foreign key(fk_id_conta) references tb_conta(id_conta)
);
select * from tb_cartao;

create table tb_comprovante(
id_comprovante           int primary key auto_increment,
valor                    varchar(20),    
data_comprovante         datetime,
conta_beneficiario       varchar(20),
descricao                varchar(20),
fk_id_conta              int,
foreign key(fk_id_conta) references tb_conta(id_conta)
);

create table tb_log(
id_log              int primary key auto_increment,
horario             datetime,
descricao           varchar(20)
);

select * from tb_uf;


-- INSERTS

INSERT INTO tb_uf (estado, sigla) VALUES
('Acre', 'AC'),
('Alagoas', 'AL'),
('Amazonas', 'AM'),
('Amapa¡', 'AP'),
('Bahia', 'BA'),
('Ceara¡', 'CE'),
('Distrito Federal', 'DF'),
('Espirito Santo', 'ES'),
('Goiais', 'GO'),
('Maranhao', 'MA'),
('Minas Gerais', 'MG'),
('Mato Grosso do Sul', 'MS'),
('Mato Grosso', 'MT'),
('Para', 'PA'),
('Paraiba', 'PB'),
('Pernambuco', 'PE'),
('Piaui', 'PI'),
('Parana¡', 'PR'),
('Rio de Janeiro', 'RJ'),
('Rio Grande do Norte', 'RN'),
('Rondonia', 'RO'),
('Roraima', 'RR'),
('Rio Grande do Sul', 'RS'),
('Santa Catarina', 'SC'),
('Sergipe', 'SE'),
('Sao Paulo', 'SP'),
('Tocantins', 'TO');

insert into tb_cliente(nome,sobrenome,cpf,data_nasc) values
("Raian","Medeiros","00000000000","2002/11/11"),
("Vyviane","Souza","00000000001","2003/12/11"),
("Mariana","Souza","00000000002","2003/09/08"),
("Nathalia","da Rocha","00000000003","2002/03/10"),
("Kevin","Alvez","00000000004","2004/11/23");

insert into tb_endereco (cep,logradouro,complemento,bairro,cidade,fk_id_uf,fk_id_cliente)  values 
('01001000','Praça da Sé','Em frente catedral da sé','Sé','São Paulo',26,2),
('04696000','Avenida Engenheiro Eusébio Stevaux','Senac Santo amaro','Jurubatuba','São Paulo',26,3),
('30140010','Praça da Liberdade','Centro historico de bh','Savassi','Belo Horizonte',11,1),
('22050900','Avenida Nossa Senhora de Copacabana','praia de copacabana','Copacabana','Rio de Janeiro',19,4),
('01310200','Avenida Paulista','Museu de arte de são paulo','Bela Vista','São Paulo',26,5);

select * from tb_uf;
select * from tb_cliente;
select * from tb_endereco;
