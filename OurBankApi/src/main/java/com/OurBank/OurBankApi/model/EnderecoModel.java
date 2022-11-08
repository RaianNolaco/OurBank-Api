package com.OurBank.OurBankApi.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int id_endereco;

    @Column(name = "cep", length = 8, nullable = true)
    private String cep;

    @Column(name = "logradouro", length = 60, nullable = true)
    private String logradouro;

    @Column(name = "complemento", length = 200)
    private String complemento;

    @Column(name = "bairro", length = 60, nullable = true)
    private String bairro;

    @Column(name = "cidade", length = 60, nullable = true)
    private String cidade;

    @Column(name = "fk_id_uf", nullable = true)
    private int idUf;

    @Column(name = "fk_id_cliente", nullable = true)
    private int idCliente;
    
}
