package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.ContaModel;


public interface IConta extends CrudRepository<ContaModel, Integer>, JpaSpecificationExecutor<ContaModel>{
    // Query para que o banco de dados traga aos dados de uma conta conforme o numero dela 
    public final static String BUSCAR_CONTA_NUMERO = "SELECT * FROM tb_conta WHERE num_conta = :numeroConta";

    // Query que busca a conta pelo Id do cliente vinculado a ela
    public final static String BUSCAR_CONTA_ID_CLIENTE = "SELECT * FROM tb_conta WHERE fk_id_cliente = :id";

    

    // Incrição do metodo para execultar a query no banco de dados
    @Query(value = BUSCAR_CONTA_NUMERO, nativeQuery =  true)
    public ContaModel findByNumeroConta(@Param("numeroConta")final String numeroConta);

    // Execulta e traz o resultado da query BUSCAR_CONTA_ID_CLIENTE
    @Query(value = BUSCAR_CONTA_ID_CLIENTE, nativeQuery =  true)
    public ContaModel findByIdCliente(@Param("id")final int id);

}
