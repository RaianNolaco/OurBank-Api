package com.OurBank.OurBankApi.controller;

import java.util.List;

import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.OurBank.OurBankApi.model.ClienteModel;
import com.OurBank.OurBankApi.service.ClienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
public class ClienteController {
    
    public ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> ListarTodosClientes(){
        return ResponseEntity.status(200).body(clienteService.listarTodosUsuarios());
    }

    @PostMapping
    public ResponseEntity<ClienteModel> CadastrarCliente(@RequestBody ClienteModel usuario){
        return ResponseEntity.status(200).body(clienteService.cadastrarCliente(usuario));
    }
}
