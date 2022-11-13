package com.OurBank.OurBankApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.OurBank.OurBankApi.model.LogModel;
import com.OurBank.OurBankApi.service.LogService;

@RestController 
@CrossOrigin("*")
@RequestMapping("/log")
public class LogController {
    
    public LogService LogService;

    public LogController(LogService logService) {
        this.LogService = logService;
    }

    // Listando todos os logs
    @GetMapping
    public ResponseEntity<List<LogModel>> listarLog() {
        List<LogModel> lista = LogService.ListarLogs();
        return ResponseEntity.status(200).body(lista);
    }
}
