package com.justa.desafio.controller;

import com.justa.desafio.model.dto.FeriadoDto;
import com.justa.desafio.model.dto.UsuarioDto;
import com.justa.desafio.service.FeriadoService;
import com.justa.desafio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    //Chama a função cadastrarUsuario via POST
    @PostMapping("/usuario/cadastrar")
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto){
        return ResponseEntity.ok(this.usuarioService.cadastrarUsuario(usuarioDto));
    }

    //Chama a função deletarUsuario via DELETE
    @DeleteMapping("/usuario/deletar")
    public ResponseEntity<UsuarioDto> deletarUsuario(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuarioDtoDelete = this.usuarioService.deletarUsuario(usuarioDto);
        if(usuarioDtoDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDtoDelete);
    }

    //Chama a função consultarUsuarioEmail via GET
    @GetMapping("/usuario/consultaremail/{email}")
    public ResponseEntity<UsuarioDto> consultarPorEmail(@PathVariable String email){
        UsuarioDto usuarioDto = this.usuarioService.consultarUsuarioEmail(email);
        if(usuarioDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDto);
    }

    //Chama a função consultarUsuarioKey via GET
    @GetMapping("/usuario/consultarkey/{key}")
    public ResponseEntity<UsuarioDto> consultarPorKey(@PathVariable String key){
        UsuarioDto usuarioDto = this.usuarioService.consultarUsuarioKey(key);
        if(usuarioDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDto);
    }

    //Chama a função editarUsuario via PUT
    @PutMapping("/usuario/editar")
    public ResponseEntity<UsuarioDto> editarUsuario(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuarioDtoEditado = this.usuarioService.editarUsuario(usuarioDto);
        if(usuarioDtoEditado==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDtoEditado);
    }

    //Chama a função gerarNovaKey via GET
    @GetMapping("/usuario/gerarnovachave/{email}")
    public ResponseEntity<UsuarioDto> gerarNovaKey(@PathVariable String email){
        UsuarioDto usuarioDto = this.usuarioService.gerarNovaKey(email);
        if(usuarioDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDto);
    }

}
