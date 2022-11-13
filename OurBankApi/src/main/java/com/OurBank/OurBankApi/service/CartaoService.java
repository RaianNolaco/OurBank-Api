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

    // Função geral de visualização por ID
    public CartaoModel visualizarCartaoId (Integer cartaoId) {
        CartaoModel cartao = repositoryCartao.findById(cartaoId).get();
        return cartao;
    }

    // Função geral de visualização por NUMERO DO CARTÃO
    public CartaoModel visualizarCartaoNumero (String numCartao) {
        CartaoModel cartao = repositoryCartao.findByNumeroCartao(numCartao);
        return cartao;
    }

    // Ativando/destivando aproximação do cartão via ID
    public CartaoModel editarAproximacaoId (Integer id) {
        CartaoModel cartao = visualizarCartaoId(id);

        if (!cartao.isAproximacao()) {
            cartao.setAproximacao(true);
        } else {
            cartao.setAproximacao(false);
        }
        repositoryCartao.save(cartao);
        return cartao;
    }

    // Ativando/destivando aproximação do cartão via numero do cartão
    public CartaoModel editarAproximacaoNum (String numeroCartao) {
        CartaoModel cartao = visualizarCartaoNumero(numeroCartao);

        if (!cartao.isAproximacao()) {
            cartao.setAproximacao(true);
        } else {
            cartao.setAproximacao(false);
        }
        repositoryCartao.save(cartao);
        return cartao;
    }

    // Ativando/destivando cartão via ID
    public CartaoModel desativarCartaoId (Integer id) {
        CartaoModel cartao = visualizarCartaoId(id);

        if (!cartao.isAtivo()) {
            cartao.setAtivo(true);
        } else {
            cartao.setAtivo(false);
        }

        repositoryCartao.save(cartao);
        return cartao;
    }

   // Ativando/destivando cartão via Numero do cartão 
    public CartaoModel desativarCartaoNum (String numCartao) {
        CartaoModel cartao = visualizarCartaoNumero(numCartao);

        if (!cartao.isAtivo()) {
            cartao.setAtivo(true);
        } else {
            cartao.setAtivo(false);
        }

        repositoryCartao.save(cartao);
        return cartao;
    }
}
