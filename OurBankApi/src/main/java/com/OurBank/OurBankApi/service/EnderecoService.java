package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.EnderecoModel;
import com.OurBank.OurBankApi.repository.IEndereco;

@Service
public class EnderecoService {
    
    private IEndereco repositoryEndereco;

    public EnderecoService(IEndereco repositoryEndereco){
        this.repositoryEndereco = repositoryEndereco;
    }

    // buscando todos os endereços no banco de dados
    public List<EnderecoModel> listarEnderecos(){
        List<EnderecoModel> listaEndereco = repositoryEndereco.findAll();
        return listaEndereco;
    }

    //adicionando um endereço no banco de dados
    public EnderecoModel addEndereco (EnderecoModel endereco) {
        EnderecoModel novoEndereco = repositoryEndereco.save(endereco);
        return novoEndereco;
    }

    //editando um enderço no banco de dados
    public EnderecoModel editaEndereco (EnderecoModel endereco){
        EnderecoModel enderecoEditado =  repositoryEndereco.save(endereco);
        return enderecoEditado;
    }

    //buscando um endereço por id no banco de dado
    public EnderecoModel buscarEndereco(int id){
        EnderecoModel endereco = repositoryEndereco.findById(id).get();
        return endereco;
    }

    //deletando um endereço do banco de dados
    public boolean deletarEndereco(Integer id) {
        repositoryEndereco.deleteById(id);
        return true;
    }
}
