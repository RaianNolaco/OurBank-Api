package com.OurBank.OurBankApi.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_catao")

public class CartaoModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_cartao")
    private int id_cartao;

    @Column(name = "num_cartao", length = 20)
    private String num_cartao;

    @Column(name = "data_validade", nullable = true)
    private String data_validade;

    @Column(name = "cvc", length = 3)
    private String cvc;

    @Column(name = "aproximacao", nullable = true)
    private String aproximacao;

    @Column(name = "ativo", nullable = true)
    private String ativo;

    @Column(name = "fk_id_conta", nullable = true)
    private String fk_id_conta;
    
}
