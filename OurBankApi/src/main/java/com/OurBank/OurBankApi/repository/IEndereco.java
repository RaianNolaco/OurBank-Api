package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OurBank.OurBankApi.model.EnderecoModel;

public interface IEndereco extends JpaRepository<EnderecoModel, Integer> {
    //master
}
