package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.CartaoModel;

public interface ICartao extends JpaRepository<CartaoModel,Integer>, JpaSpecificationExecutor<CartaoModel>{
    public final static String BUSCAR_POR_NUMEROCARTAO = "SELECT * FROM tb_cartao WHERE num_cartao = :numeroCartao";

    @Query(value = BUSCAR_POR_NUMEROCARTAO, nativeQuery = true)
    public CartaoModel findByNumeroCartao(@Param("numeroCartao")final String numeroCartao);


}
