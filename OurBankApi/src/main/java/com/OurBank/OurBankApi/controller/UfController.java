package com.OurBank.OurBankApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.OurBank.OurBankApi.model.UfModel;
import com.OurBank.OurBankApi.service.UfService;

@RestController
@CrossOrigin("*")
@RequestMapping("/uf")
public class UfController {

	public UfService ufService;
	
	public UfController(UfService ufService){
		this.ufService = ufService;
	}
	
	/*Em geral todos os metodos em uma controller servem para se comunicar com os metodos service 
	que servem para inserir, alterar, buscar ou remover alguma informação do banco de dados */


	// metodo ultilizado para listar todos os Uf
	@GetMapping
	public ResponseEntity<List<UfModel>> listarUfs(){
		List<UfModel> lista = ufService.listarUfs();
		return ResponseEntity.status(200).body(lista);
	}

	//Buscando Uf por id
	@GetMapping("/{id}")
	public ResponseEntity<UfModel>buscarUf(@PathVariable int id){
		return ResponseEntity.status(200).body(ufService.buscarUf(id));
	}

	// Buscando Uf pela sigla do estado
	@GetMapping("/uf")
	public ResponseEntity<UfModel>buscarUfporUf(@RequestHeader String uf){
		String ufUpper = uf.toUpperCase();
		return ResponseEntity.status(200).body(ufService.buscarUfporUF(ufUpper));
	}
	
}
