package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.EnderecoModel;
import com.OurBank.OurBankApi.repository.IEndereco;

@Service
public class EnderecoService {
    
    private IEndereco repository;

    public EnderecoService(IEndereco repository){
        this.repository = repository;
    }

    public List<EnderecoModel> listarEnderecos(){
        List<EnderecoModel> listaEndereco = repository.findAll();
        return listaEndereco;
    }

}
