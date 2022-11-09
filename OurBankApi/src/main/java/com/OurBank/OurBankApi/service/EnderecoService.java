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

    public EnderecoModel addEndereco (EnderecoModel endereco) {
        EnderecoModel novoEndereco = repository.save(endereco);
        return novoEndereco;
    }

    public EnderecoModel editaEndereco (EnderecoModel endereco){
        EnderecoModel enderecoEditado =  repository.save(endereco);
        return enderecoEditado;
    }

    public EnderecoModel buscarEndereco(int id){
        EnderecoModel endereco = repository.findById(id).get();
        return endereco;
    }

    public boolean deletarEndereco(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
