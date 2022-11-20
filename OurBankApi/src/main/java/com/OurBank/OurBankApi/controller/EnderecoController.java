package com.OurBank.OurBankApi.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.OurBank.OurBankApi.model.EnderecoModel;
import com.OurBank.OurBankApi.service.EnderecoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


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
    public ResponseEntity<EnderecoModel> CriarEndereco (@Valid @RequestBody EnderecoModel endereco) {
        return ResponseEntity.status(201).body(enderecoService.addEndereco(endereco));
    }

    // Editando um endereço
    @PutMapping
    public ResponseEntity<EnderecoModel> EditarEndereco(@Valid @RequestBody EnderecoModel endereco) {
        return ResponseEntity.status(200).body(enderecoService.editaEndereco(endereco));
    }

    //Buscando um endereço por id
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> BuscarEndereco(@PathVariable Integer id){
        return ResponseEntity.status(200).body(enderecoService.buscarEndereco(id));
    }

    @GetMapping("/idcliente/{id}")
    public ResponseEntity<EnderecoModel> buscarEnderecoIdCliente(@PathVariable Integer id){
        return ResponseEntity.status(200).body(enderecoService.buscarMeuEndereco(id));
    }

    //metodo serve para remover resgistro da base de dados
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Integer id){
        enderecoService.deletarEndereco(id);
        return ResponseEntity.status(204).build();
    }
    

    @DeleteMapping("/idcliente/{id}")
    public ResponseEntity<?> deletarEnderecoIdCliente(@PathVariable Integer id){
        enderecoService.deletarMeuEndereco(id);
        return ResponseEntity.status(204).build();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> validationException (MethodArgumentNotValidException ex) {
        Map<String,String> erros = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            erros.put(fieldName, errorMessage);
        });

        return erros;
    }
}
