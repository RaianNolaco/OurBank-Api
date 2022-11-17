package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.OurBank.OurBankApi.model.ComprovanteModel;
import com.OurBank.OurBankApi.model.TranferenciasModel;

import java.util.List;

public interface IComprovante extends JpaRepository<ComprovanteModel, Integer> {
        // esse é um select criado para podermos para buscarmos todas nossas trasferencias
        public final static String BUSCAR_TRANSF = "SELECT * FROM vw_trasferencia WHERE fk_id_conta= :id";

        //esse é um select pra buscar todos meus comprovantes
        public final static String BUSCAR_COMPROVANTES = "SELECT * FROM tb_comprovante WHERE fk_id_conta= :id";
    
        // aqui no metodo nos expecificamos para o JPA que queremos execultar a varivel BUSCAR_POR_CPF 
        @Query(value = BUSCAR_TRANSF,nativeQuery = true)
        public List<TranferenciasModel> findByTranferencia(@Param("id")final Integer id);

        @Query(value = BUSCAR_COMPROVANTES,nativeQuery = true)
        public List<ComprovanteModel> findComprovantesConta(@Param("id")final int id);
}
