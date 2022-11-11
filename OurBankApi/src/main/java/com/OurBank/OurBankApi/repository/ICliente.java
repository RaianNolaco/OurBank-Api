package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.ClienteModel;

public interface ICliente extends JpaRepository<ClienteModel,Integer>, JpaSpecificationExecutor<ClienteModel> {   
    public final static String BUSCAR_POR_CPF = "SELECT * FROM tb_cliente WHERE cpf = :cpf";
    
    @Query(value = BUSCAR_POR_CPF,nativeQuery = true)
    public ClienteModel FindByCpf(@Param("cpf")final String cpf);
}

