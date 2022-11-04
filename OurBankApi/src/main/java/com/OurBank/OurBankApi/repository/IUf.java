package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OurBank.OurBankApi.model.UfModel;

public interface IUf extends JpaRepository<UfModel, Integer> {
}
