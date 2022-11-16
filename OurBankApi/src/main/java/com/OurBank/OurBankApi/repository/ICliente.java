package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.ClienteModel;


public interface ICliente extends JpaRepository<ClienteModel,Integer>, JpaSpecificationExecutor<ClienteModel> {   
   
    // esse é um select criado para podermos para buscarmos o cliente via cpd 
    public final static String BUSCAR_POR_CPF = "SELECT * FROM tb_cliente WHERE cpf = :cpf";
    
    // aqui no metodo nos expecificamos para o JPA que queremos execultar a varivel BUSCAR_POR_CPF 
    @Query(value = BUSCAR_POR_CPF,nativeQuery = true)
    public ClienteModel findByCpf(@Param("cpf")final String cpf);
}

