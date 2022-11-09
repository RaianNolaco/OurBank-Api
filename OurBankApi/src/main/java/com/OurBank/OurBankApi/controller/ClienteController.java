package com.OurBank.OurBankApi.controller;

import java.util.List;
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
        return ResponseEntity.status(201).body(clienteService.cadastrarCliente(usuario));
    }

    @PutMapping
    public ResponseEntity<ClienteModel> EditarCliente(@RequestBody ClienteModel usuario){
        return ResponseEntity.status(201).body(clienteService.editarCliente(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> BuscarCliente(@PathVariable Integer id){ 
        return ResponseEntity.status(200).body(clienteService.buscarCliente(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletarCliente(@PathVariable Integer id){
        clienteService.deletarCliente(id);
        return ResponseEntity.status(204).build();
    }
}
