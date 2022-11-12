package com.OurBank.OurBankApi.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.OurBank.OurBankApi.model.CartaoModel;
import com.OurBank.OurBankApi.service.CartaoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cartao")
public class CartaoController {

    public CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService){
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public ResponseEntity<List<CartaoModel>> ListarTodosCartoes(){
        return ResponseEntity.status(200).body(cartaoService.listarTodosCartoes());
    }  

    @GetMapping("/{id}")
    public ResponseEntity<CartaoModel> buscarCartao (@PathVariable Integer id) {
        return ResponseEntity.status(201).body(cartaoService.visualizarCartao(id));
    }
    
    //Destiva a aprocimação do cartão por Id
    @PutMapping("ativaraprocimacao")
    public ResponseEntity<CartaoModel> desativarAproximCartao (@RequestHeader String numeroCartao) {
        return ResponseEntity.status(201).body(cartaoService.editarAproximacao(numeroCartao));
    }



}
