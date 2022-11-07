package com.OurBank.OurBankApi.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_comprovante")

public class ComprovanteModel {

@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name = "id_comprovante")
private int id_comprovante;

@Column(name = "valor", length = 20)
private String valor;

@Column(name = "data_comprovante", nullable = true)
private String data_comprovante;

@Column(name = "conta_beneficiario", length = 20)
private String conta_beneficiario;

@Column(name = "descricao", length = 20)
private String descricao;

@Column(name = "fk_id_conta", nullable = true)
private int fk_id_conta;
    
}
