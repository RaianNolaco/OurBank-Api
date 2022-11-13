package com.OurBank.OurBankApi.service;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ClienteModel;
import com.OurBank.OurBankApi.repository.ICliente;

import java.util.List;

@Service
public class ClienteService {

    private ICliente repositoryCliente;

    public ClienteService(ICliente repositoryCliente){
        this.repositoryCliente = repositoryCliente;
    }

    //listando todos os clientes 
    public List<ClienteModel> listarTodosUsuarios(){
        List<ClienteModel> listaClientes = repositoryCliente.findAll();
        return listaClientes;
    }

    //adicionando um cliente novo
    public ClienteModel cadastrarCliente(ClienteModel cliente){
        ClienteModel novoCliente = repositoryCliente.save(cliente);
        return novoCliente;
    }

    //editando os dados de um cliente
    public ClienteModel editarCliente(ClienteModel cliente){
        ClienteModel editarCliente = repositoryCliente.save(cliente);
        return editarCliente;
    }

    //buscando um cliente via Id
    public ClienteModel buscarCliente(Integer id){
        ClienteModel cliente = repositoryCliente.findById(id).get();
        return cliente;
    }

    //Buscando um cliente vida cpf
    public ClienteModel buscarClientePorCpf(String cpf){
       ClienteModel cliente = repositoryCliente.findByCpf(cpf);
        return cliente;
    }

    //deletando um cliente
    public boolean deletarCliente(Integer id) {
        repositoryCliente.deleteById(id);
        return true;
    }

    

}

