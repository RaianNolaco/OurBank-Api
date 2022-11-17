package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.EnderecoModel;
import com.OurBank.OurBankApi.repository.IEndereco;

@Service
public class EnderecoService {
    
    private IEndereco repositoryEndereco;
    private LogService logService;

    public EnderecoService(IEndereco repositoryEndereco,LogService logService){
        this.repositoryEndereco = repositoryEndereco;
        this.logService = logService;
    }

    // buscando todos os endereços no banco de dados
    public List<EnderecoModel> listarEnderecos(){
        List<EnderecoModel> listaEndereco = repositoryEndereco.findAll();
        return listaEndereco;
    }

    //adicionando um endereço no banco de dados
    public EnderecoModel addEndereco (EnderecoModel endereco) {
        repositoryEndereco.save(endereco);

        String descricao = "ENDERECO CADASTRADO | METODO: POST | CEP : " + endereco.getCep()+ " | ID CLIENTE: " + endereco.getIdCliente() ;
        logService.gravarLog(descricao);

        return endereco;
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

        EnderecoModel endereco = repositoryEndereco.findById(id).get();

        String descricao = "ENDERECO DELETADO | METODO: POST | CEP : " + endereco.getCep()+ " | ID CLIENTE: " + endereco.getIdCliente() ;
        logService.gravarLog(descricao);

        return true;
    }

    public boolean deletarMeuEndereco(Integer idCliente) {
        
        EnderecoModel endereco = buscarMeuEndereco(idCliente);
        repositoryEndereco.deleteById(endereco.getId_endereco());

        String descricao = "ENDERECO DELETADO | METODO: POST | CEP : " + endereco.getCep()+ " | ID CLIENTE: " + endereco.getIdCliente() ;
        logService.gravarLog(descricao);

        return true;
    }

    public EnderecoModel buscarMeuEndereco(Integer id) {
        EnderecoModel endereco = repositoryEndereco.findByIdCliente(id);
        return endereco;
    }
}
