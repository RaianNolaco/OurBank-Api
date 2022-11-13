package com.OurBank.OurBankApi.model;

import javax.persistence.*;

import lombok.Data;

//Está model representa a tabela de comprovantes no banco de dados
@Data
@Entity
@Table(name = "tb_comprovante")

public class ComprovanteModel {

@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name = "id_comprovante")
private int idComprovante;

@Column(name = "valor", length = 20)
private String valor;

@Column(name = "data_comprovante", nullable = false)
private String dataComprovante;

@Column(name = "conta_beneficiario", length = 20)
private String contaBeneficiario;

@Column(name = "descricao", length = 20)
private String descricao;

@Column(name = "fk_id_conta", nullable = false)
private int fk_id_conta;
    
}
