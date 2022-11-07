package com.OurBank.OurBankApi.model;

import javax.persistence.*;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_log")

public class LogModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_log")
    private int id_log;

    @Column(name = "horario", nullable = true)
    private String horario;

    @Column(name = "descricao", length = 20)
    private String descricao;
}
