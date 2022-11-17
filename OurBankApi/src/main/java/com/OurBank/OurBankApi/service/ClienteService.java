package com.OurBank.OurBankApi.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ClienteModel;
import com.OurBank.OurBankApi.repository.ICliente;

import java.util.List;

@Service
public class ClienteService {

    private ICliente repositoryCliente;
    private LogService logService;
    private ContaService contaService; 
    private PasswordEncoder passwordEncoder;

    //Construtor da classe clienteService
    public ClienteService(ICliente repositoryCliente, LogService logService, ContaService contaService){
        this.repositoryCliente = repositoryCliente;
        this.logService = logService;
        this.contaService = contaService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    //listando todos os clientes 
    public List<ClienteModel> listarTodosUsuarios(){
        List<ClienteModel> listaClientes = repositoryCliente.findAll();
        return listaClientes;
    }

    //adicionando um cliente novo
    public ClienteModel cadastrarCliente(ClienteModel cliente){
        String emailUper = cliente.getEmail().toUpperCase();
        cliente.setEmail(emailUper);

        String encoder = this.passwordEncoder.encode(cliente.getSenha());
        cliente.setSenha(encoder);

        ClienteModel novoCliente = repositoryCliente.save(cliente);
        contaService.cadastrarConta(novoCliente.getIdCliente());

        String descricao = "CLIENTE CADASTRADO| METODO: POST | NOME : " +cliente.getNome()+ " | CPF: " + cliente.getCpf() ;
        logService.gravarLog(descricao);
        return novoCliente;
    }

    //editando os dados de um cliente
    public ClienteModel editarCliente(ClienteModel cliente){
        String emailUper = cliente.getEmail().toUpperCase();
        cliente.setEmail(emailUper);

        String encoder = this.passwordEncoder.encode(cliente.getSenha());
        cliente.setSenha(encoder);

        ClienteModel editarCliente = repositoryCliente.save(cliente);

        String descricao = "CLIENTE EDITADO| METODO: PUT | NOME : " +cliente.getNome()+ " | CPF: " + cliente.getCpf() ;
        logService.gravarLog(descricao);

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
        ClienteModel cliente = repositoryCliente.findById(id).get();

        String descricao = "CLIENTE DELETADO | METODO: DELETE | NOME : " +cliente.getNome()+ " | CPF: " + cliente.getCpf() ;
        logService.gravarLog(descricao);

        repositoryCliente.deleteById(id);
        return true;
    }

    // buscando cliente por email
    public ClienteModel buscarClientePorEmail(String email){
        String emailUpper = email.toUpperCase();
        ClienteModel cliente = repositoryCliente.findByEmail(emailUpper);
        return cliente;
    }

    public boolean login( String email, String senha){

        ClienteModel cliente = repositoryCliente.findByEmail(email.toUpperCase());
        String senhaBanco = cliente.getSenha();

        Boolean valid = passwordEncoder.matches(senha, senhaBanco);
        return valid;

    }
    

}

