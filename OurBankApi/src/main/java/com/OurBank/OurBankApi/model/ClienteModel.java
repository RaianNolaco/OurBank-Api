package com.OurBank.OurBankApi.model;

import lombok.Data;

import javax.persistence.*;

//Está model representa a tabela de clientes no banco de dados
@Data
@Entity
@Table(name = "tb_cliente")

public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idConta;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "sobrenome", length = 50, nullable = false)
    private String sobrenome;    
   
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "data_nasc", nullable = false)
    private String dataNasc;

}
