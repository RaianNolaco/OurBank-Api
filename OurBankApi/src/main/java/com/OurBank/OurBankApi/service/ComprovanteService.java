package com.OurBank.OurBankApi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.OurBank.OurBankApi.model.ComprovanteModel;
import com.OurBank.OurBankApi.model.TranferenciasModel;
import com.OurBank.OurBankApi.repository.IComprovante;
import com.OurBank.OurBankApi.repository.ITransferencia;

@Service
public class ComprovanteService {

    private IComprovante repository;
    private ITransferencia repos;
    private LogService logService;

    public ComprovanteService(IComprovante repository,LogService logService, ITransferencia repos) {
        this.repository = repository;
        this.logService = logService;
        this.repos = repos;
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

    public List<TranferenciasModel> buscarTransferencias (int id) {
        List<TranferenciasModel> transferencias = repos.findByTranferencia(id);
        return transferencias;
    }

    public ComprovanteModel editaDescComprovante(int id, String txt) {

        ComprovanteModel editaComprovante = repository.findById(id).get();
        editaComprovante.setDescricao(txt);

        String descricao = "COMPROVANTE EDITADO | METODO: PUT | DATA COMPROVANTE : " +editaComprovante.getDataComprovante()+ " | ID CONTA: " + editaComprovante.getFk_id_conta() ;
        logService.gravarLog(descricao);

        return editaComprovante;
    }

    // Deletando comprovante via ID
    public Boolean deletarComprovante(Integer id) {

        ComprovanteModel comprovante = repository.findById(id).get();

        repository.deleteById(id);
        String descricao = "COMPROVANTE DELTADO| METODO: DELETE | DATA COMPROVANTE : " +comprovante.getDataComprovante()+ " | ID CONTA: " + comprovante.getFk_id_conta() ;
        logService.gravarLog(descricao);

       
        return true;
    }

    public Boolean deletarTodosMeusComprovante(int idConta) {
        List<ComprovanteModel> comprovantes = repository.findComprovantesConta(idConta);

        for (ComprovanteModel comprovante : comprovantes) {
            repository.deleteById(comprovante.getIdComprovante());
        }

        String descricao = "COMPROVANTES DELTADOS| METODO: DELETE | ID CONTA: " + idConta ;
        logService.gravarLog(descricao);

     
        return true;
    }

}
