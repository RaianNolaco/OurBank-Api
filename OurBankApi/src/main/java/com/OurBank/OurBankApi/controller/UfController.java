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
	
	@GetMapping
	public ResponseEntity<List<UfModel>> ListarUfs(){
		List<UfModel> lista = ufService.listarUfs();
		return ResponseEntity.status(200).body(lista);
	}

	@GetMapping("/teste")
	public String Teste(){
		return "Helloword";
	}
	
}
