package com.OurBank.OurBankApi.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vw_transferencia")
public class TranferenciasModel {

    @Id
    @Column(name = "id_comprovante", nullable=false)
    private int id_comprovante;

    @Column(name = "nome", length=50, nullable=false)
    private String nome;

    @Column(name = "valor", nullable=false)
    private double valor;
    
    @Column(name = "data_comprovante", nullable=false)
    private String data_comprovante;

    @Column(name = "conta_beneficiario", length=20, nullable=false)
    private String conta_beneficiario;

    @Column(name = "descricao", length=300)
    private String descricao;

    @Column(name = "fk_id_conta", nullable=false)
    private int fk_id_conta;
}
