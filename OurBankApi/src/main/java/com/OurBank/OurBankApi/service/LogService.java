package com.OurBank.OurBankApi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.OurBank.OurBankApi.model.LogModel;
import com.OurBank.OurBankApi.repository.ILog;

@Service
public class LogService {

    private ILog repository;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

 
    public LogService(ILog repository) {
        this.repository = repository;
    }

    // Buscando todos os logs da base de dados
    public List<LogModel> ListarLogs() {
        List<LogModel> listarLog = repository.findAll();
        return listarLog;
    }  

    public void gravarLog(String descricao){
        
        String horario = dtf.format(LocalDateTime.now());

        LogModel log = new LogModel(horario,descricao); 
        repository.save(log);
    }
    
}

