/*
package com.justa.desafio.controller;


import com.justa.desafio.model.dto.PrincipalDto;
import com.justa.desafio.service.PrincipalService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;*/
/*
@RestController
public class PrincipalController {


    private PrincipalService principalService;
    public PrincipalController(PrincipalService principalService){this.principalService = principalService;}

    @GetMapping("/principal/{dia}/{mes}/{ano}/{codigo}")
    public ResponseEntity<PrincipalDto> buscarFeriadosDoAno(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano, @PathVariable String codigo) throws IOException {
        PrincipalDto principalDto = this.principalService.buscarFeriadosDoAno(dia, mes, ano, codigo);
        return ResponseEntity.ok(principalDto);
    }

    @GetMapping("/principal")
    public ResponseEntity<PrincipalDto> teste(){
        PrincipalDto principalDto = this.principalService.teste();
        return ResponseEntity.ok(principalDto);
    }

}
*/
