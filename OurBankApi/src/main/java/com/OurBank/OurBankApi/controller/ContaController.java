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

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }
    
    @GetMapping
    public ResponseEntity<List<ContaModel>> ListarConta() {
        return ResponseEntity.status(200).body(contaService.listarConta());
    }

    @PostMapping
    public ResponseEntity<ContaModel> CriarConta(@RequestBody ContaModel conta) {
        return ResponseEntity.status(200).body(contaService.criarConta(conta));
    }

    @PutMapping
    public ResponseEntity<ContaModel> EditarConta(@RequestBody ContaModel conta) {
        return ResponseEntity.status(200).body(contaService.editaConta(conta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaModel> BuscarConta(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(contaService.buscarConta(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletarConta(@PathVariable Integer id) {
        contaService.deletarConta(id);
        return ResponseEntity.status(204).build();
    }
}
