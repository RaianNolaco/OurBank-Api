package com.OurBank.OurBankApi.controller;

import java.util.List;

import javax.validation.Valid;

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

    // buisca todos clientes da base de dados
    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarTodosClientes(){
        return ResponseEntity.status(200).body(clienteService.listarTodosUsuarios());
    }

    // incluindo cliente
    @PostMapping
    public ResponseEntity<ClienteModel> cadastrarCliente(@Valid @RequestBody ClienteModel usuario){
        return ResponseEntity.status(201).body(clienteService.cadastrarCliente(usuario));
    }

    // Editando cliente 
    @PutMapping
    public ResponseEntity<ClienteModel> editarCliente(@Valid @RequestBody ClienteModel usuario){
        return ResponseEntity.status(201).body(clienteService.editarCliente(usuario));
    }

    // buscando cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarCliente(@PathVariable Integer id){ 
        return ResponseEntity.status(200).body(clienteService.buscarCliente(id));
    }

    //Está model representa a tabela de Uf no banco de dados
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id){
        clienteService.deletarCliente(id);
        return ResponseEntity.status(204).build();
    }
    
    // Buscando cliente por CPF
    @GetMapping("/cpf")
    public ResponseEntity<ClienteModel> BuscarClientePorCpf(@RequestHeader String cpf){ 
        return ResponseEntity.status(200).body(clienteService.buscarClientePorCpf(cpf));
    }
}
