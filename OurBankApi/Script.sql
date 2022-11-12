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
email				 varchar(80) not null,
cpf                  varchar(11) unique,
senha				 varchar(20) not null,
data_nasc            date
);

create table tb_endereco(
id_endereco           int primary key auto_increment,
cep                   varchar(8) not null,
logradouro            varchar(60) not null,
numero   			  varchar(10)not null,
complemento			  varchar(300),
bairro                varchar(60) not null,
cidade				  varchar(60) not null,
fk_id_uf              int not null,
fk_id_cliente 		  int not null,
foreign key(fk_id_uf) references tb_uf(id_uf),
foreign key(fk_id_cliente) references tb_cliente(id_cliente)
);

create table tb_conta(
id_conta           int primary key auto_increment,
num_conta          varchar(16) not null unique,
cod_banco          varchar(20) not null,
agencia            varchar(4) not null,
saldo              decimal(10.2),
fk_id_cliente      int not null,
foreign key(fk_id_cliente) references tb_cliente(id_cliente)
);


create table tb_cartao(
id_cartao           int primary key auto_increment,
num_cartao          varchar(10) not null unique,
data_validade       date not null,
cvc                 varchar(3)not null,
aproximacao         boolean not null,
ativo               boolean not null, 
fk_id_conta         int not null,
foreign key(fk_id_conta) references tb_conta(id_conta)
);
select * from tb_cartao;

create table tb_comprovante(
id_comprovante           int primary key auto_increment,
valor                    varchar(20) not null,    
data_comprovante         datetime not null,
conta_beneficiario       varchar(20) not null, 
descricao                varchar(300),
fk_id_conta              int not null,
foreign key(fk_id_conta) references tb_conta(id_conta)
);

create table tb_log(
id_log              int primary key auto_increment,
horario             datetime,
descricao           varchar(300)
);

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

insert into tb_cliente(nome,email,cpf,senha,data_nasc) values
("Raian Medeiros","RaiNolac@gmail.com","00000000000","123abc","2002/11/11"),
("Vyviane Souza","Vyvis@yahoo.com","00000000001","456dfg","2003/12/11"),
("Mariana Souza","MariSou@hotmail.com","00000000002","789hij","2003/09/08"),
("Nathalia da Rocha","Rocha@gmail.com","00000000003","101klm","2002/03/10"),
("Kevin Alvez","Kalves@gmail.com","00000000004","121nop","2004/11/23");

insert into tb_endereco (cep,logradouro,numero,complemento,bairro,cidade,fk_id_uf,fk_id_cliente)  values 
('01001000','Praça da Sé',"12",'Em frente catedral da sé','Sé','São Paulo',26,2),
('04696000','Avenida Engenheiro Eusébio Stevaux',"56",'Senac Santo amaro','Jurubatuba','São Paulo',26,3),
('30140010','Praça da Liberdade',"32C",'Centro historico de bh','Savassi','Belo Horizonte',11,1),
('22050900','Avenida Nossa Senhora de Copacabana',"16",'praia de copacabana','Copacabana','Rio de Janeiro',19,4),
('01310200','Avenida Paulista',"32",'Museu de arte de são paulo','Bela Vista','São Paulo',26,5);

insert into tb_conta (num_conta,cod_banco,agencia,saldo,fk_id_cliente)  values 
					("0000001",42,002,10,1),
                    ("0000002",42,002,10,2),
                    ("0000003",42,002,10,3),
                    ("0000004",42,002,10,4),
                    ("0000005",42,002,10,5);

insert into tb_cartao (num_cartao,data_validade,cvc,aproximacao,ativo,fk_id_conta)  values 
					("000000001",'2025/12/11',123,true,true,1),
                    ("000000002",'2026/11/20',321,false,false,2),
                    ("000000003",'2028/02/11',123,true,false,3),
                    ("000000004",'2030/01/17',321,false,true,4),
                    ("000000005",'2027/07/09',321,false,true,5);
                    
                    

select * from tb_uf;
select * from tb_cliente;
select * from tb_endereco;
select * from tb_conta;
select * from tb_cartao;