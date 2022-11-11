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
    private int idCartao;

    @Column(name = "num_cartao", length = 20)
    private String numCartao;

    @Column(name = "data_validade", nullable = false)
    private String dataValidade;

    @Column(name = "cvc", length = 3)
    private String cvc;

    @Column(name = "aproximacao", nullable = false)
    private boolean aproximacao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "fk_id_conta", nullable = false)
    private String fk_id_conta;
    
}
