package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ContaModel;
import com.OurBank.OurBankApi.repository.IConta;
import com.OurBank.OurBankApi.geral.*;

@Service
public class ContaService {

    private IConta contaRepository;
    private LogService logService;
    private CartaoService cartaoService;

    public ContaService(IConta contaRepository,LogService logService, CartaoService cartaoService){
        this.contaRepository = contaRepository;
        this.logService = logService;
        this.cartaoService = cartaoService;
    }

    // Listando todas as contas
    public List<ContaModel> listarContas(){
        return (List<ContaModel>)contaRepository.findAll();
    }

    // Buscando conta por ID
    public ContaModel buscarContaId(int id){
        return contaRepository.findById(id).get();
    }

    // Cadastrando uma nova contra
    public ContaModel cadastrarConta(Integer id){
        ContaModel conta = new ContaModel();
        conta.setNumConta(ContaFunc.numConta());
        conta.setAgencia(ContaFunc.agencia());
        conta.setCodBanco(ContaFunc.codBanco());
        conta.setSaldo(0);
        conta.setFk_id_cliente(id);

        ContaModel novaConta = contaRepository.save(conta);
        cartaoService.cadastrarCartao(novaConta.getIdConta());

        String descricao = "CONTRA CADASTRADA | METODO: POST | NUMERO CONTA : " +conta.getNumConta()+ " | ID CLIENTE: " + conta.getFk_id_cliente() ;
        logService.gravarLog(descricao);

        return novaConta;
    }

    // Editando os dados de uma conta
    public boolean deletarConta(int id){
        contaRepository.deleteById(id);
        ContaModel conta =  contaRepository.findById(id).get();

        String descricao = "CONTRA DELETADA | METODO: DELETE | NUMERO CONTA : " +conta.getNumConta()+ " | ID CLIENTE: " + conta.getFk_id_cliente() ;
        logService.gravarLog(descricao);

        return true;
    }

    // Buscando conta por numero da conta
    public ContaModel buscarContaPorNumero(String numeroConta){
        return contaRepository.findByNumeroConta(numeroConta);
    }
}
