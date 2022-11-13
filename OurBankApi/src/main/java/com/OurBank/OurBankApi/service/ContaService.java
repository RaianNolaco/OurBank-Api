package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.ContaModel;
import com.OurBank.OurBankApi.repository.IConta;

@Service
public class ContaService {

    private IConta contaRepository;
    private LogService logService;

    public ContaService(IConta contaRepository,LogService logService){
        this.contaRepository = contaRepository;
        this.logService = logService;
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
    public ContaModel cadastrarConta(ContaModel conta){
        contaRepository.save(conta);

        String descricao = "CONTRA CADASTRADA | METODO: POST | NUMERO CONTA : " +conta.getNumConta()+ " | ID CLIENTE: " + conta.getFk_id_cliente() ;
        logService.gravarLog(descricao);

        return conta;
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
