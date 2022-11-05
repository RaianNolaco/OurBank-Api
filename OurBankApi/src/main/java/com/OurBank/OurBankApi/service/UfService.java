package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.UfModel;
import com.OurBank.OurBankApi.repository.IUf;

@Service
public class UfService {

	private IUf repository;
	
	public UfService(IUf repository) {
		this.repository = repository;
	}
	
	public List<UfModel> listarUfs(){
		System.out.println("Entrou na service");
		List<UfModel> listaUf = repository.findAll();
		return listaUf;
	}
	
}
