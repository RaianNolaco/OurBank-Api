package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.UfModel;

public interface IUf extends JpaRepository<UfModel, Integer>, JpaSpecificationExecutor<UfModel> {
    public final static String BUSCAR_POR_UF = "SELECT * FROM tb_uf WHERE sigla = :uf";

    @Query(value = BUSCAR_POR_UF,nativeQuery = true)
    public UfModel findByUf(@Param("uf")final String uf);
    
}
