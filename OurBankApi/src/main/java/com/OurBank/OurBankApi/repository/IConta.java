package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.ContaModel;


public interface IConta extends JpaRepository<ContaModel, Integer>, JpaSpecificationExecutor<ContaModel>{
    public final static String BUSCAR_CONTA_NUMERO = "SELECT * FROM tb_conta WHERE num_conta = :numeroConta";

    @Query(value = BUSCAR_CONTA_NUMERO, nativeQuery =  true)
    public ContaModel findByNumeroConta(@Param("numeroConta")final String numeroConta);
}
