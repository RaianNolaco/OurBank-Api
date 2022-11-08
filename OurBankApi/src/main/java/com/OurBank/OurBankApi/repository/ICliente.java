package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OurBank.OurBankApi.model.ClienteModel;

public interface ICliente extends JpaRepository<ClienteModel,Integer> {   
}
