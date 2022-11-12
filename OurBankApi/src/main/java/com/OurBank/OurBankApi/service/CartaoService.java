package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.CartaoModel;
import com.OurBank.OurBankApi.repository.ICartao;

@Service
public class CartaoService {

    private ICartao repositoryCartao;

    public CartaoService(ICartao repositoryCartao) {
        this.repositoryCartao = repositoryCartao;
    }

    public List<CartaoModel> listarTodosCartoes(){
        List<CartaoModel> cartoes = repositoryCartao.findAll();
        return cartoes;
    }

    public CartaoModel visualizarCartao (Integer cartaoId) {
        CartaoModel cartao = repositoryCartao.findById(cartaoId).get();
        return cartao;
    }

    public CartaoModel editarAproximacao (Integer id) {
        CartaoModel cartao = visualizarCartao(id);

        if (!(cartao.isAproximacao())) {
            cartao.setAproximacao(true);
        } else {
            cartao.setAproximacao(false);
        }
        repositoryCartao.save(cartao);
        return cartao;
    }

    public CartaoModel editarAproximacao (String numeroCartao) {
        CartaoModel cartao = repositoryCartao.findByNumeroCartao(numeroCartao);

        if (!(cartao.isAproximacao())) {
            cartao.setAproximacao(true);
        } else {
            cartao.setAproximacao(false);
        }
        repositoryCartao.save(cartao);
        return cartao;
    }
}
