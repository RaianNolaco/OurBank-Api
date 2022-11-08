package com.OurBank.OurBankApi.service;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ClienteModel;
import com.OurBank.OurBankApi.repository.ICliente;
import java.util.List;

@Service
public class ClienteService {
    

    private ICliente repository;

    public ClienteService(ICliente repository){
        this.repository = repository;
    }

    public List<ClienteModel> listarTodosUsuarios(){
        List<ClienteModel> listaClientes = repository.findAll();
        return listaClientes;
    }

    public ClienteModel cadastrarCliente(ClienteModel cliente){
        ClienteModel novoCliente = repository.save(cliente);
        return novoCliente;
    }

}
