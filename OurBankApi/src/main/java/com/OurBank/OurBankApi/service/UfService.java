package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.UfModel;
import com.OurBank.OurBankApi.repository.IUf;

@Service
public class UfService {

	private IUf repositoryUf;
	
	public UfService(IUf repositoryUf) {
		this.repositoryUf = repositoryUf;
	}
	
	//metodo que busca do bando de dados a lista de ufs
	public List<UfModel> listarUfs(){
		List<UfModel> listaUf = repositoryUf.findAll();
		return listaUf;
	}

	public UfModel buscarUf(int id){
		return repositoryUf.findById(id).get();
	}
	
	//Buscando Uf por sigla da base de dados
	public UfModel buscarUfporUF(String uf){
		return repositoryUf.findByUf(uf);
	}
}
