package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OurBank.OurBankApi.model.ContaModel;

public interface IConta extends JpaRepository<ContaModel,Integer> {
    
}
