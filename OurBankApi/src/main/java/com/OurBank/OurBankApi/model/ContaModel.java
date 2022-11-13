package com.OurBank.OurBankApi.model;

import javax.persistence.Entity;

import lombok.Data;
import javax.persistence.*;

//Está model representa a tabela de contas no banco de dados
@Data
@Entity
@Table(name = "tb_conta")

public class ContaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_conta")
    private int idConta;

    @Column(name = "num_conta", length = 16)
    private String numConta;

    @Column(name = "cod_banco", length = 20)
    private String codBanco;

    @Column(name = "agencia", length = 4)
    private String agencia;

    @Column(name = "saldo", length = 10)
    private double saldo;

    @Column(name = "fk_id_cliente", nullable = false)
    private int fk_id_cliente;

    
}
