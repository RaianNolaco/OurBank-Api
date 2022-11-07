package com.OurBank.OurBankApi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_cliente")

public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id_conta;

    @Column(name = "nome", length = 40, nullable = true)
    private String nome;
   
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "data_nasc", nullable = true)
    private String data_nasc;

    @Column(name = "fk_id_endereco", nullable = true)
    private int fk_id_endereco;

}
