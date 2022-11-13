package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OurBank.OurBankApi.model.ComprovanteModel;

public interface IComprovante extends JpaRepository<ComprovanteModel, Integer> {
    
}
