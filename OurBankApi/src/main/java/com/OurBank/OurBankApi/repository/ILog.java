package com.OurBank.OurBankApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OurBank.OurBankApi.model.LogModel;

public interface ILog extends JpaRepository<LogModel,Integer> {   
}

