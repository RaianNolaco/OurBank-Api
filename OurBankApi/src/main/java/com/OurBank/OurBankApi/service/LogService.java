package com.OurBank.OurBankApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.LogModel;
import com.OurBank.OurBankApi.repository.ILog;

@Service
public class LogService {

    private ILog repository;
 
    public LogService(ILog repository) {
        this.repository = repository;
    }

    public List<LogModel> ListarLogs() {
        List<LogModel> listarLog = repository.findAll();
        return listarLog;
    }  
}

