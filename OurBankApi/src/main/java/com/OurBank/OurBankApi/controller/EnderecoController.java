package com.OurBank.OurBankApi.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.OurBank.OurBankApi.model.EnderecoModel;
import com.OurBank.OurBankApi.service.EnderecoService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin("*")
@RequestMapping("/endereco")
public class EnderecoController {
     
    public EnderecoService enderecoService; 

    public EnderecoController(EnderecoService endservice){
		this.enderecoService = endservice;
	}
    
    //Buscando todos endereços
    @GetMapping
    public ResponseEntity<List<EnderecoModel>> ListarEnderecos(){
        List<EnderecoModel> lista = enderecoService.listarEnderecos();
        return ResponseEntity.status(200).body(lista);
    }

    //Registrando um endereço
    @PostMapping
    public ResponseEntity<EnderecoModel> CriarEndereco (@RequestBody EnderecoModel endereco) {
        return ResponseEntity.status(201).body(enderecoService.addEndereco(endereco));
    }

    // Editando um endereço
    @PutMapping
    public ResponseEntity<EnderecoModel> EditarEndereco(@RequestBody EnderecoModel endereco) {
        return ResponseEntity.status(200).body(enderecoService.editaEndereco(endereco));
    }

    //Buscando um endereço por id
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> BuscarEndereco(@PathVariable Integer id){
        return ResponseEntity.status(200).body(enderecoService.buscarEndereco(id));
    }

    //metodo serve para remover resgistro da base de dados
    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletarEndereco(@PathVariable Integer id){
        enderecoService.deletarEndereco(id);
        return ResponseEntity.status(204).build();
    }
    
}
