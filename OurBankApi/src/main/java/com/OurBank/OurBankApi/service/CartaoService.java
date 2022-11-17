package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.geral.CartaoFunc;
import com.OurBank.OurBankApi.model.CartaoModel;
import com.OurBank.OurBankApi.repository.ICartao;

@Service
public class CartaoService {

    private ICartao repositoryCartao;
    private LogService logService;

    public CartaoService(ICartao repositoryCartao, LogService logService) {
        this.repositoryCartao = repositoryCartao;
        this.logService = logService;
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

    // Função para cadastrar um novocartão
    public CartaoModel cadastrarCartao(Integer id){
        CartaoModel cartao = new CartaoModel();
        cartao.setNumCartao(CartaoFunc.numCartao());
        cartao.setCvc(CartaoFunc.cvc());
        cartao.setDataValidade(CartaoFunc.validade());
        cartao.setAtivo(true);
        cartao.setFk_id_conta(id);

        repositoryCartao.save(cartao);
        logService.gravarLog("CARTAO CADASTRADO | METODO: POST | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta());
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

        String descricao;
        if (!cartao.isAproximacao()) {
            cartao.setAproximacao(true);
            descricao = "APROXIMACAO CARTAO ATIVADO | METODO: PUT | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta();

        } else {
            cartao.setAproximacao(false);
            descricao = "APROXIMACAO CARTAO DESATIVADO | METODO: PUT | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta() ;

        }

        repositoryCartao.save(cartao);
        logService.gravarLog(descricao);
        
        return cartao;
    }

    // Ativando/destivando aproximação do cartão via numero do cartão
    public CartaoModel editarAproximacaoNum (String numeroCartao) {
        CartaoModel cartao = visualizarCartaoNumero(numeroCartao);

        String descricao;
        if (!cartao.isAproximacao()) {
            cartao.setAproximacao(true);
            descricao = "APROXIMACAO CARTAO ATIVADO | METODO: PUT | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta() ;

        } else {
            cartao.setAproximacao(false);
            descricao = "APROXIMACAO CARTAO DESATIVADO | METODO: PUT | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta() ;

        }

        repositoryCartao.save(cartao);
        logService.gravarLog(descricao);

        return cartao;
    }

    // Ativando/destivando cartão via ID
    public CartaoModel desativarCartaoId (Integer id) {
        CartaoModel cartao = visualizarCartaoId(id);

        String descricao;
        if (!cartao.isAtivo()) {
            cartao.setAtivo(true);
            descricao = "CARTAO ATIVADO | METODO: PUT | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta() ;

        } else {
            cartao.setAtivo(false);
            descricao = "CARTAO DESATIVADO | METODO: PUT | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta() ;

        }

        repositoryCartao.save(cartao);
        logService.gravarLog(descricao);

        return cartao;
    }

   // Ativando/destivando cartão via Numero do cartão 
    public CartaoModel desativarCartaoNum (String numCartao) {
        CartaoModel cartao = visualizarCartaoNumero(numCartao);


        String descricao;
        if (!cartao.isAtivo()) {
            cartao.setAtivo(true);
            descricao = "CARTAO ATIVADO | METODO: PUT | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta() ;

        } else {
            cartao.setAtivo(false);
            descricao = "CARTAO DESATIVADO | METODO: PUT | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta() ;

        }

        repositoryCartao.save(cartao);
        logService.gravarLog(descricao);

        return cartao;
    }

    public boolean deletarCartao (Integer cartaoId) {
        CartaoModel cartao = visualizarCartaoId(cartaoId);
        repositoryCartao.deleteById(cartaoId);
        logService.gravarLog("CARTAO DELETADO | METODO: DELETE | NUMERO DO CARTAO : " +cartao.getNumCartao()+ " | ID CONTA: " + cartao.getFk_id_conta());
        return true;
    }

    public CartaoModel buscarCartaoIdConta(int idConta){
        return repositoryCartao.findByIdConta(idConta);  
    }

    public boolean deletarCartaoIdConta(int idConta) {
    
        CartaoModel cartao =  buscarCartaoIdConta(idConta);
        deletarCartao(cartao.getIdCartao());
        return true;
    }
}
