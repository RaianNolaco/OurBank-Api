package com.OurBank.OurBankApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.OurBank.OurBankApi.model.ComprovanteModel;
import com.OurBank.OurBankApi.service.ComprovanteService;


@RestController 
@CrossOrigin("*")
@RequestMapping("/comprovante")
public class ComprovanteController {

    public ComprovanteService comprovanteService;

    public ComprovanteController(ComprovanteService comprovanteService) {
        this.comprovanteService = comprovanteService;
    }
    
    @GetMapping
    public ResponseEntity<List<ComprovanteModel>> ListaComprovante() {
        return ResponseEntity.status(200).body(comprovanteService.listaComprovante());
    }
    
    @PostMapping
    public ResponseEntity<ComprovanteModel> GerarComprovante(@RequestBody ComprovanteModel comprovante) {
        return ResponseEntity.status(200).body(comprovanteService.gerarComprovante(comprovante));
    }

    @PutMapping
    public ResponseEntity<ComprovanteModel> EditaComprovante(@RequestBody ComprovanteModel comprovante) {
        return ResponseEntity.status(200).body(comprovanteService.editaComprovante(comprovante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComprovanteModel> BuscarComprovante(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(comprovanteService.buscarComprovante(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletarComprovante(@PathVariable Integer id) {
        comprovanteService.deletarComprovante(id);
        return ResponseEntity.status(204).build();
    }
}
