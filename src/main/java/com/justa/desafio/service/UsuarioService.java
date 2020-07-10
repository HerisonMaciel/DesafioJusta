package com.justa.desafio.service;

import com.justa.desafio.model.Usuario;
import com.justa.desafio.model.dto.UsuarioDto;
import com.justa.desafio.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    //criando injeção de dependencia
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    //Função para cadastrar usuario
    public UsuarioDto cadastrarUsuario(UsuarioDto usuarioDto){
        return salvarUsuario(usuarioDto);
    }

    //Função para salvar usuário no banco de dados
    public UsuarioDto salvarUsuario(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario(usuarioDto.getEmail());
        Usuario usuarioSave = this.usuarioRepository.save(usuario);
        return new UsuarioDto(usuarioSave.getEmail(), usuarioSave.getKey());
    }

    //Função para deletar um usuário verificando email e key
    public UsuarioDto deletarUsuario(UsuarioDto usuarioDto){
        Usuario usuario = this.usuarioRepository.findByEmail(usuarioDto.getEmail());
        if(usuario==null){
            return null;
        }
        this.usuarioRepository.delete(usuario);
        return usuarioDto;
    }

    //Consultar Usuario por Email
    public UsuarioDto consultarUsuarioEmail(String email){
        Usuario usuario = this.usuarioRepository.findByEmail(email);
        if(usuario==null){
            return null;
        }
        UsuarioDto usuarioDtoNovo = new UsuarioDto(usuario.getEmail(), usuario.getKey());
        return usuarioDtoNovo;
    }

    //Consultar Usuario por Email
    public UsuarioDto consultarUsuarioKey(String key){
        Usuario usuario = this.usuarioRepository.findByKey(key);
        if(usuario==null){
            return null;
        }
        UsuarioDto usuarioDtoNovo = new UsuarioDto(usuario.getEmail(), usuario.getKey());
        return usuarioDtoNovo;
    }

    //Edita o Usuario passado uma lista (primeiro da lista atual, segundo da lista o novo)
    public UsuarioDto editarUsuario(UsuarioDto usuarioDto){
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(usuarioDto.getId());
        if(!usuarioOptional.isPresent()){
            return null;
        }
        Usuario usuario = usuarioOptional.get();
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setKey(usuarioDto.getKey());
        this.usuarioRepository.save(usuario);
        return usuarioDto;
    }

    //Gerar uma nova key
    public UsuarioDto gerarNovaKey(String email){
        Usuario usuario = this.usuarioRepository.findByEmail(email);
        if(usuario==null){
            return null;
        }
        usuario.setKey(usuario.gerarKey());
        UsuarioDto usuarioDto = new UsuarioDto(usuario.getEmail(), usuario.getKey());
        this.usuarioRepository.save(usuario);
        return usuarioDto;
    }

}
