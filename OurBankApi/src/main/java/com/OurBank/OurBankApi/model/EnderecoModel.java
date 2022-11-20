package com.OurBank.OurBankApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

//Está model representa a tabela de endereços no banco de dados
@Data
@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int id_endereco;

    @NotEmpty(message = "CEP é obrigatório!")
    @NotNull(message = "CEP não pode ser nulo")
    @NotBlank(message = "CEP não pode ser vazio")
    @Size(min = 8, max = 8, message = "CEP deve ter 8 digitos")
    @Column(name = "cep", length = 8, nullable = false)
    private String cep;


    @NotEmpty(message = "O campo logradouro é obrigatório!")
    @NotNull(message = "O campo logradouro não pode ser nulo")
    @NotBlank(message = "O campo logradouro não pode ser vazio")
    @Column(name = "logradouro", length = 60, nullable = false)
    private String logradouro;

    @NotEmpty(message = "O campo numero é obrigatório!")
    @NotNull(message = "O campo numero não pode ser nulo")
    @NotBlank(message = "O campo numero não pode ser vazio")
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    
    @Column(name = "complemento", length = 200)
    private String complemento;

    @NotEmpty(message = "O campo bairro é obrigatório!")
    @NotNull(message = "O campo bairro não pode ser nulo")
    @NotBlank(message = "O campo bairro não pode ser vazio")
    @Column(name = "bairro", length = 60, nullable = false)
    private String bairro;

    @NotEmpty(message = "O campo cidade é obrigatório!")
    @NotNull(message = "O campo cidade não pode ser nulo")
    @NotBlank(message = "O campo cidade não pode ser vazio")
    @Column(name = "cidade", length = 60, nullable = false)
    private String cidade;

    @Column(name = "fk_id_uf", nullable = false)
    private int idUf;

    @Column(name = "fk_id_cliente", nullable = false)
    private int idCliente;
    
}
