package com.OurBank.OurBankApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	public ResponseEntity<List<UfModel>> ListarUfs(){
		return ResponseEntity.status(200).body(ufService.listarUfs());
	}
	
}
