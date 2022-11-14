package com.OurBank.OurBankApi.model;

import java.sql.Date;

import javax.persistence.*;


import lombok.Data;


//Está model representa a tabela de cartoes no banco de dados
@Data
@Entity
@Table(name = "tb_cartao")

public class CartaoModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao")
    private int idCartao;

    @Column(name = "num_cartao", length = 10)
    private String numCartao;

    @Column(name = "data_validade", nullable = false)
    private Date dataValidade;

    @Column(name = "cvc", length = 3)
    private String cvc;

    @Column(name = "aproximacao", nullable = false)
    private boolean aproximacao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "fk_id_conta", nullable = false)
    private int fk_id_conta;
    
}
