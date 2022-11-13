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

    @GetMapping
    public ResponseEntity<List<ContaModel>> listarContas(){
        return ResponseEntity.status(200).body(contaService.listarContas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ContaModel> buscarConta(@PathVariable int id){
        return ResponseEntity.status(200).body(contaService.buscarContaId(id));
    }

    @PostMapping
    public ResponseEntity<ContaModel> cadastrarConta(@RequestBody ContaModel conta){
        return ResponseEntity.status(200).body(contaService.cadastrarConta(conta));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarConta(@PathVariable int id){
        return ResponseEntity.status(200).body(contaService.deletarConta(id));
    }

    @GetMapping("/numeroconta")
    public ResponseEntity<ContaModel> buscarContaNumero(@RequestHeader String numeroConta){
        return ResponseEntity.status(200).body(contaService.buscarContaPorNumero(numeroConta));
    }
}
