package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ContaModel;
import com.OurBank.OurBankApi.repository.IConta;

@Service
public class ContaService {

    private IConta repository;

    public ContaService(IConta repository) {
        this.repository = repository;
    }

    public List<ContaModel> listarConta() {
        List<ContaModel> listarConta = repository.findAll();
        return listarConta;
    }
    
    public ContaModel criarConta(ContaModel conta) {
        ContaModel criarConta = repository.save(conta);
        return criarConta;
    }

    public ContaModel editaConta(ContaModel conta) {
        ContaModel contaEditada = repository.save(conta);
        return contaEditada;
    }

    public ContaModel buscarConta(int id) {
        ContaModel buscandoConta = repository.findById(id).get();
        return buscandoConta;
    }

    public Boolean deletarConta(Integer id) {
        repository.deleteById(id);
        return true;
    }
}