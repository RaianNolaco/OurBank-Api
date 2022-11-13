package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ComprovanteModel;
import com.OurBank.OurBankApi.repository.IComprovante;

@Service
public class ComprovanteService {

    private IComprovante repository;

    public ComprovanteService(IComprovante repository) {
        this.repository = repository;
    }
    
    // listando todos os comprovantes da base de dados
    public List<ComprovanteModel> listaComprovante() {
        List<ComprovanteModel> listaComprovante = repository.findAll();
        return listaComprovante;
    }

    // Criando um comprovante novo na base de dados
    public ComprovanteModel gerarComprovante(ComprovanteModel comprovante) {
        ComprovanteModel gerarComprovante = repository.save(comprovante);
        return gerarComprovante;
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
        repository.deleteById(id);
        return true;
    }
}
