package com.justa.desafio.controller;

import com.justa.desafio.model.Data;
import com.justa.desafio.model.dto.DataDto;
import com.justa.desafio.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private DataService dataService;
    public DataController(DataService dataService){ this.dataService = dataService; }

    @GetMapping("/numero/{mes}/{dia}")
    public ResponseEntity<DataDto> dataFatoHistorico(@PathVariable String mes,@PathVariable String dia){
        DataDto dataDto = this.dataService.dataFatoHistorico(mes, dia);
        return ResponseEntity.ok(dataDto);
    }

    @GetMapping("numero/curiosidade/{numero}")
    public ResponseEntity<DataDto> numeroCurisidade(@PathVariable String numero){
        DataDto dataDto = this.dataService.numeroCurisidade(numero);
        return ResponseEntity.ok(dataDto);
    }

    @GetMapping("numero/matematico/{numero}")
    public ResponseEntity<DataDto> numeroMatematico(@PathVariable String numero){
        DataDto dataDto = this.dataService.numeroCurisidade(numero);
        return ResponseEntity.ok(dataDto);
    }

    @GetMapping("numero/curiosidade/matematico/{numero}")
    public ResponseEntity<DataDto[]> numeroCuriosidadeMatematico(@PathVariable String numero){
        DataDto[] dataDto = this.dataService.numeroCurisidadeNumero(numero);
        return ResponseEntity.ok(dataDto);
    }
}
