package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.OurBank.OurBankApi.model.TranferenciasModel;

import java.util.List;

public interface ITransferencia extends JpaRepository<TranferenciasModel, Integer> {
        // esse é um select criado para podermos para buscarmos o cliente via cpd 
        public final static String BUSCAR_TRANSF = "SELECT * FROM vw_transferencia WHERE fk_id_conta= :id";
    
        // aqui no metodo nos expecificamos para o JPA que queremos execultar a varivel BUSCAR_POR_CPF 
        @Query(value = BUSCAR_TRANSF,nativeQuery = true)
        public List<TranferenciasModel> findByTranferencia(@Param("id")final Integer id);
}
