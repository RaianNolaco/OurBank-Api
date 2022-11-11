package com.OurBank.OurBankApi.model;

import javax.persistence.*;

import javax.persistence.Entity;

import lombok.Data;

//Está model representa a tabela de log no banco de dados
@Data
@Entity
@Table(name = "tb_log")

public class LogModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_log")
    private int id_log;

    @Column(name = "horario", nullable = false)
    private String horario;

    @Column(name = "descricao", length = 20)
    private String descricao;
}
