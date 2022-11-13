package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.ContaModel;


public interface IConta extends JpaRepository<ContaModel, Integer>, JpaSpecificationExecutor<ContaModel>{
    // Query para que o banco de dados traga aos dados de uma conta conforme o numero dela 
    public final static String BUSCAR_CONTA_NUMERO = "SELECT * FROM tb_conta WHERE num_conta = :numeroConta";

    // Incrição do metodo para execultar a query no banco de dados
    @Query(value = BUSCAR_CONTA_NUMERO, nativeQuery =  true)
    public ContaModel findByNumeroConta(@Param("numeroConta")final String numeroConta);
}
