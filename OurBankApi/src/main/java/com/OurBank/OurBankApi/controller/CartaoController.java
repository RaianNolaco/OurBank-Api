package com.OurBank.OurBankApi.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.OurBank.OurBankApi.model.CartaoModel;
import com.OurBank.OurBankApi.service.CartaoService;
import com.OurBank.OurBankApi.geral.CartaoFunc;

@RestController
@CrossOrigin("*")
@RequestMapping("/cartao")
public class CartaoController {

    public CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService){
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public ResponseEntity<List<CartaoModel>> listarTodosCartoes(){
        return ResponseEntity.status(200).body(cartaoService.listarTodosCartoes());
    }  

    @GetMapping("/{id}")
    public ResponseEntity<CartaoModel> buscarCartao (@PathVariable Integer id) {
        return ResponseEntity.status(200).body(cartaoService.visualizarCartaoId(id));
    }
    
    //Destiva a aproximação do cartão por Numero do cartao
    @PutMapping("/aproximacao")
    public ResponseEntity<CartaoModel> desativarAproximCartaoNum (@RequestHeader String numeroCartao) {
        return ResponseEntity.status(201).body(cartaoService.editarAproximacaoNum(numeroCartao));
    }

    // Desativa a aproximação do cartão por Id
    @PutMapping("/aproximacao/{id}")
    public ResponseEntity<CartaoModel> desativarAproximCartaoId (@PathVariable Integer id) {
        return ResponseEntity.status(201).body(cartaoService.editarAproximacaoId(id));
    }

    // Ativa/Desativa o cartão por ID
    @PutMapping("/ativarcartao/{id}")
    public ResponseEntity<CartaoModel> desativarCartaoId (@PathVariable Integer id) {
        return ResponseEntity.status(201).body(cartaoService.desativarCartaoId(id));
    }

    // Ativa/Desativa o cartão por Numero do cartão
    @PutMapping("/ativarcartao")
    public ResponseEntity<CartaoModel> desativarCartaoNum (@RequestHeader String numeroCartao) {
        CartaoModel cartao = cartaoService.desativarCartaoNum(numeroCartao);
        return ResponseEntity.status(201).body(cartao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCartao(@PathVariable int id){
        return ResponseEntity.status(204).body(cartaoService.deletarCartao(id));
    }

}
