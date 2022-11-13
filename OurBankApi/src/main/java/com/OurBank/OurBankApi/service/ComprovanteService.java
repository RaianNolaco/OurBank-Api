package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ComprovanteModel;
import com.OurBank.OurBankApi.repository.IComprovante;

@Service
public class ComprovanteService {

    private IComprovante repository;
    private LogService logService;

    public ComprovanteService(IComprovante repository,LogService logService) {
        this.repository = repository;
        this.logService = logService;
    }
    
    // listando todos os comprovantes da base de dados
    public List<ComprovanteModel> listaComprovante() {
        List<ComprovanteModel> listaComprovante = repository.findAll();
        return listaComprovante;
    }

    // Criando um comprovante novo na base de dados
    public ComprovanteModel gerarComprovante(ComprovanteModel comprovante) {
        repository.save(comprovante);

        String descricao = "COMPROVANTE GERADO | METODO: POST | DATA COMPROVANTE : " +comprovante.getDataComprovante()+ " | ID CONTA: " + comprovante.getFk_id_conta() ;
        logService.gravarLog(descricao);

        return comprovante;
    }

    // Editando os dados de um comprovante
    public ComprovanteModel editaComprovante(ComprovanteModel comprovante) {
        ComprovanteModel editaComprovante = repository.save(comprovante);
        return editaComprovante;
    }

    // buscando comprovante via ID
    public ComprovanteModel buscarComprovante(int id) {
        ComprovanteModel buscarComprovante = repository.findById(id).get();
        return buscarComprovante;
    }

    // Deletando comprovante via ID
    public Boolean deletarComprovante(Integer id) {

        ComprovanteModel comprovante = repository.findById(id).get();

        String descricao = "COMPROVANTE DELTADO| METODO: DELETE | DATA COMPROVANTE : " +comprovante.getDataComprovante()+ " | ID CONTA: " + comprovante.getFk_id_conta() ;
        logService.gravarLog(descricao);

        repository.deleteById(id);
        return true;
    }
}
