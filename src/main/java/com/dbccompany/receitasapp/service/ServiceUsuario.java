package com.dbccompany.receitasapp.service;

import com.dbccompany.receitasapp.dto.UsuarioDTO;
import com.dbccompany.receitasapp.dto.UsuarioFormado;
import com.dbccompany.receitasapp.repository.RepositorioUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServiceUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public List<UsuarioFormado> listarTodosUsuarios(){
        return null;
    }

    public UsuarioFormado encontrarUsuarioPorId(Integer idUsario){
        return null;
    }

    public UsuarioFormado criarUsuario(UsuarioDTO usuarioDTO){
        return null;
    }

    public UsuarioFormado atualizarUsuario(UsuarioDTO usuarioDTO, Integer idUsuario){
        return null;
    }

    public UsuarioFormado deletarUsuario(Integer idUsuario){
        return null;
    }

}
