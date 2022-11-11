package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OurBank.OurBankApi.model.CartaoModel;

public interface ICartao extends JpaRepository<CartaoModel,Integer>{
}
