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
    
    public List<ComprovanteModel> listaComprovante() {
        List<ComprovanteModel> listaComprovante = repository.findAll();
        return listaComprovante;
    }

    public ComprovanteModel gerarComprovante(ComprovanteModel comprovante) {
        ComprovanteModel gerarComprovante = repository.save(comprovante);
        return gerarComprovante;
    }

    public ComprovanteModel editaComprovante(ComprovanteModel comprovante) {
        ComprovanteModel editaComprovante = repository.save(comprovante);
        return editaComprovante;
    }

    public ComprovanteModel buscarComprovante(int id) {
        ComprovanteModel buscarComprovante = repository.findById(id).get();
        return buscarComprovante;
    }

    public Boolean deletarComprovante(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
