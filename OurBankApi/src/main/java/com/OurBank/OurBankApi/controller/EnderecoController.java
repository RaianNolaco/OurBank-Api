package com.OurBank.OurBankApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OurBank.OurBankApi.model.EnderecoModel;
import com.OurBank.OurBankApi.service.EnderecoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/endereco")
public class EnderecoController {
     
    public EnderecoService enderecoService; 

    public EnderecoController(EnderecoService endservice){
		this.enderecoService = endservice;
	}
    
    @GetMapping
    public ResponseEntity<List<EnderecoModel>> ListarEnderecos(){
        List<EnderecoModel> lista = enderecoService.listarEnderecos();
        return ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<EnderecoModel> criarEndereco (@RequestBody EnderecoModel endereco) {
        return ResponseEntity.status(201).body(enderecoService.addEndereco(endereco));
    }

    
    
}
