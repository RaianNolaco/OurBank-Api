package com.OurBank.OurBankApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.EnderecoModel;

public interface IEndereco extends JpaRepository<EnderecoModel, Integer> {
   
    public final static String BUSCAR_MEU_ENDERECO = "SELECT * FROM tb_endereco WHERE fk_id_cliente = :id";
    
    // aqui no metodo nos expecificamos para o JPA que queremos execultar a varivel BUSCAR_MEU_ENDERECO 
    @Query(value = BUSCAR_MEU_ENDERECO,nativeQuery = true)
    EnderecoModel findByIdCliente(@Param("id")final Integer id);
}
