package com.justa.desafio.controller;

import com.justa.desafio.model.Feriado;
import com.justa.desafio.model.dto.FeriadoDto;
import com.justa.desafio.service.FeriadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.List;

@RestController
public class FeriadoController {


    private FeriadoService feriadoService;
    public FeriadoController(FeriadoService feriadoService){ this.feriadoService = feriadoService; }

    @GetMapping("/feriados/{year}/{countryCode}")
    public ResponseEntity<List<FeriadoDto>> feriadosDoPaisAno(@PathVariable String year, @PathVariable String countryCode){
        List<FeriadoDto> feriadoDtos = (this.feriadoService.feriadosDoPaisAno(year, countryCode));
       return ResponseEntity.ok(feriadoDtos);
    }

    @GetMapping("feriados/{countryCode}")
    public ResponseEntity<List<FeriadoDto>> proximosFeriadosAno(@PathVariable String countryCode){
        List<FeriadoDto> feriadoDtos = (this.feriadoService.proximosFeriadosAno(countryCode));
        return ResponseEntity.ok(feriadoDtos);
    }

    @GetMapping("feriados/buscar/{dia}/{mes}/{ano}/{codigo}")
    public ResponseEntity<FeriadoDto> proximosFeriadosMundiais(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano, @PathVariable String codigo){
        FeriadoDto feriadoDtos = (this.feriadoService.buscarFeriado(dia, mes, ano, codigo));
        return ResponseEntity.ok(feriadoDtos);
    }

}
