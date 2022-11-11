package com.OurBank.OurBankApi.service;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.CartaoModel;
import com.OurBank.OurBankApi.repository.ICartao;

@Service
public class CartaoService {

    private ICartao repository;

    public CartaoService(ICartao repository) {
        this.repository = repository;
    }

    public CartaoModel visualizarCartao (Integer cartaoId) {
        CartaoModel cartao = repository.findById(cartaoId).get();
        return cartao;
    }

    public CartaoModel editarAproximacao (Integer id) {
        CartaoModel cartao = visualizarCartao(id);

        if (!(cartao.isAproximacao())) {
            cartao.setAproximacao(true);
        } else {
            cartao.setAproximacao(false);
        }
        repository.save(cartao);
        return cartao;
    }
}
