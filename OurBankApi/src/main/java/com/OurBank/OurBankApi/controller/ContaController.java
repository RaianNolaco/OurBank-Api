package com.OurBank.OurBankApi.controller;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.OurBank.OurBankApi.model.ContaModel;
import com.OurBank.OurBankApi.service.ContaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/conta")
public class ContaController {

    public ContaService contaService;
    
    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    // Buscando todas as contas
    @GetMapping
    public ResponseEntity<List<ContaModel>> listarContas(){
        return ResponseEntity.status(200).body(contaService.listarContas());
    }


    // Buscando conta por ID
    @GetMapping("/{id}")
    public ResponseEntity<ContaModel> buscarConta(@PathVariable int id){
        return ResponseEntity.status(200).body(contaService.buscarContaId(id));
    }


    // // Cadastrando uma conta
    // @PostMapping
    // public ResponseEntity<ContaModel> cadastrarConta(@RequestBody ContaModel conta){
    //     return ResponseEntity.status(200).body(contaService.cadastrarConta(conta));
    // }


    // Deletando conta por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarConta(@PathVariable int id){
        return ResponseEntity.status(200).body(contaService.deletarConta(id));
    }

    // Buscando conta pelo numero da conta
    @GetMapping("/numeroconta")
    public ResponseEntity<ContaModel> buscarContaNumero(@RequestHeader String numeroConta){
        return ResponseEntity.status(200).body(contaService.buscarContaPorNumero(numeroConta));
    }
}
