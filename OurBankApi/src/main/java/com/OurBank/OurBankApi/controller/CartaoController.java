package com.OurBank.OurBankApi.controller;

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
    
    @PutMapping("/{id}")
    public ResponseEntity<CartaoModel> desativarAproximCartao (@PathVariable Integer id) {
        return ResponseEntity.status(201).body(cartaoService.editarAproximacao(id));
    }
}
