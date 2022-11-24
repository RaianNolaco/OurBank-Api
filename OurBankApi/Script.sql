show databases;
drop database if exists db_OurBank;
create database db_OurBank;
use db_OurBank;
show tables;

-- Tabela de Unidades federativas
create table tb_uf(
id_uf           int primary key auto_increment,
estado          varchar(25),
sigla           char(2)
);

-- Tabela de clientes
create table tb_cliente(
id_cliente           int primary key auto_increment,
nome                 varchar(50) not null,
email				 varchar(80) not null unique,
cpf                  varchar(11) not null unique,
senha				 text not null,
data_nasc            date
);

-- Tabela de enderecos
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

-- Tabela de contas
create table tb_conta(
id_conta           int primary key auto_increment,
num_conta          varchar(11) not null unique,
cod_banco          varchar(20) not null,
agencia            varchar(4) not null,
saldo              double,
fk_id_cliente      int not null,
foreign key(fk_id_cliente) references tb_cliente(id_cliente)
);

-- Tabela de cartoes 
create table tb_cartao(
id_cartao           int primary key auto_increment,
num_cartao          varchar(20) not null unique,
data_validade       date not null,
cvc                 varchar(3)not null,
aproximacao         boolean not null,
ativo               boolean not null, 
fk_id_conta         int not null,
foreign key(fk_id_conta) references tb_conta(id_conta)
);

-- Tabela de comprovantes
create table tb_comprovante(
id_comprovante           int primary key auto_increment,
valor                    decimal(10,2) not null,    
data_comprovante         datetime not null,
conta_beneficiario       varchar(20) not null, 
descricao                varchar(300),
fk_id_conta              int not null,
foreign key(fk_id_conta) references tb_conta(id_conta)
);

-- Tabela de logs
create table tb_log(
id_log              int primary key auto_increment,
horario             varchar(30),
descricao           varchar(300)
);

-- INSERTS

-- Inserindo dados de Ufs
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

-- Inserindo clientes
insert into tb_cliente(nome,email,cpf,senha,data_nasc) values
("RAIAN MEDEIROS","RAINOLAC@GMAIL.COM","00000000000","123ABC","2002/11/11"),
("VYVIANE SOUZA","VYVIS@YAHOO.COM","00000000001","456DFG","2003/12/11"),
("MARIANA SOUZA","MARISOU@HOTMAIL.COM","00000000002","789HIJ","2003/09/08"),
("NATHALIA DA ROCHA","ROCHA@GMAIL.COM","00000000003","101KLM","2002/03/10"),
("KEVIN ALVEZ","KALVES@GMAIL.COM","00000000004","121NOP","2004/11/23");

--  Inserindo endereços
insert into tb_endereco (cep,logradouro,numero,complemento,bairro,cidade,fk_id_uf,fk_id_cliente)  values 
('01001000','Praça da Sé',"12",'Em frente catedral da sé','Sé','São Paulo',26,2),
('04696000','Avenida Engenheiro Eusébio Stevaux',"56",'Senac Santo amaro','Jurubatuba','São Paulo',26,3),
('30140010','Praça da Liberdade',"32C",'Centro historico de bh','Savassi','Belo Horizonte',11,1),
('22050900','Avenida Nossa Senhora de Copacabana',"16",'praia de copacabana','Copacabana','Rio de Janeiro',19,4),
('01310200','Avenida Paulista',"32",'Museu de arte de são paulo','Bela Vista','São Paulo',26,5);

-- inserindo contas 
insert into tb_conta (num_conta,cod_banco,agencia,saldo,fk_id_cliente)  values 
					("00000001-0",217,0081,10,1),
                    ("00000002-0",217,0081,10,2),
                    ("00000003-0",217,0081,10,3),
                    ("00000004-0",217,0081,10,4),
                    ("00000005-0",217,0081,10,5);

-- inserindo contas
insert into tb_cartao (num_cartao,data_validade,cvc,aproximacao,ativo,fk_id_conta)  values 
					("0000 0000 0000 0001",'2025/12/11',123,true,true,1),
                    ("0000 0000 0000 0002",'2026/11/20',321,false,false,2),
                    ("0000 0000 0000 0003",'2028/02/11',123,true,false,3),
                    ("0000 0000 0000 0004",'2030/01/17',321,false,true,4),
                    ("0000 0000 0000 0005",'2027/07/09',321,false,true,5);
    
 -- Inserindo comprovantes   
insert into tb_comprovante (valor,data_comprovante,conta_beneficiario,descricao,fk_id_conta) value
(100,'2022/11/12','0000002','pagamento',1),
(50,'2022/11/19','0000002','pagamento',2),
(10,'2022/01/17','0000003','trasferencia',3),
(100,'2022/11/12','0000004','pagamento',1),
(100,'2022/01/30','0000002','trasferencia',4),
(230,'2022/11/12','0000002','pagamento',5),
(100,'2022/12/29','0000001','pagamento',2),
(100,'2022/03/10','0000003','trasferencia',3),
(100,'2022/05/12','0000004','trasferencia',2),
(100,'2022/11/22','0000001','pagamento',5),
(100,'2022/02/12','0000005','trasferencia',4),
(100,'2022/06/15','0000001','trasferencia',2),
(10,'2022/03/13','0000002','pagamento',3);                    
  
-- view para trazer nomde do clinte beneficiario (que recebe a trasferencia)
CREATE VIEW vw_transferencia as
	SELECT 
    CLI.nome,
    CPE.*
    FROM tb_comprovante   AS CPE
	INNER JOIN tb_conta   AS CON    ON CON.num_conta = CPE.conta_beneficiario
    INNER JOIN tb_cliente AS CLI    ON CLI.id_cliente = CON.fk_id_cliente;    
    
    
                    
-- selects 
select * from tb_uf;	
select * from tb_cliente;
select * from tb_endereco;
select * from tb_comprovante;
select * from tb_conta;
Select * from tb_log;
select * from vw_transferencia where fk_id_conta=1;