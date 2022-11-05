show databases;
drop database db_OurBank;
create database db_OurBank;
use db_OurBank;
show tables;

create table tb_uf(
id_uf           int primary key auto_increment,
estado          varchar(25),
sigla           char(2)
);

create table tb_endereco(
id_endereco           int primary key auto_increment,
logradouro            varchar(50),
cep                   varchar(8) not null,
bairro                char(20),
uf                    char(2),
fk_id_uf              int,
foreign key(fk_id_uf) references tb_uf(id_uf) 
);

create table tb_cliente(
id_cliente           int primary key auto_increment,
nome                 varchar(40) not null,
cpf                  varchar(11) unique,
data_nasc            date,
fk_id_endereco       int,
foreign key(fk_id_endereco) references tb_endereco(id_endereco)
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

INSERT INTO `tb_uf` (`estado`, `sigla`) VALUES
('Acre', 'AC'),
( 'Alagoas', 'AL'),
( 'Amazonas', 'AM'),
( 'Amapa¡', 'AP'),
( 'Bahia', 'BA'),
( 'Ceara¡', 'CE'),
( 'Distrito Federal', 'DF'),
( 'Espirito Santo', 'ES'),
( 'Goiais', 'GO'),
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