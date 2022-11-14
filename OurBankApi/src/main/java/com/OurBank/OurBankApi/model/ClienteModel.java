package com.OurBank.OurBankApi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

//Está model representa a tabela de clientes no banco de dados
@Data
@Entity
@Table(name = "tb_cliente")

public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idConta;

    @NotEmpty(message = "O nome é obrigatório!")
    @Size(min=2, message="O nome deve, no mínimo, ter 3 caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Email(message="Insira um e-mail válido!")
    @NotEmpty(message = "O e-mail é obrigatório!")
    @Column(name = "email", length = 80, nullable = false)
    private String email;    
   
    @NotEmpty(message = "O CPF é obrigatório!")
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Size(min=5, message="A senha deve, no mínimo, ter 5 caracteres")
    @NotEmpty(message = "A senha é obrigatória!")
    @Column(name = "senha", length = 11)
    private String senha;

    @NotEmpty(message = "A data de nascimento é obrigatória!")
    @Column(name = "data_nasc", nullable = false)
    private String dataNasc;

}
