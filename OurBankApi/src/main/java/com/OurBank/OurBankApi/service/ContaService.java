package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ContaModel;
import com.OurBank.OurBankApi.repository.IConta;

@Service
public class ContaService {

    private IConta contaRepository;

    public ContaService(IConta contaRepository){
        this.contaRepository = contaRepository;
    }

    public List<ContaModel> listarContas(){
        return (List<ContaModel>)contaRepository.findAll();
    }

    public ContaModel buscarContaId(int id){
        return contaRepository.findById(id).get();
    }

    public ContaModel cadastrarConta(ContaModel conta){
        contaRepository.save(conta);
        return conta;
    }

    public boolean deletarConta(int id){
        contaRepository.deleteById(id);
        return true;
    }

    public ContaModel buscarContaPorNumero(String numeroConta){
        return contaRepository.findByNumeroConta(numeroConta);
    }
}
