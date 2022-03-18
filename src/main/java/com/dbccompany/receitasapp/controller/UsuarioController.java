package com.dbccompany.receitasapp.controller;


import com.dbccompany.receitasapp.dto.UsuarioDTO;
import com.dbccompany.receitasapp.dto.UsuarioFormado;
import com.dbccompany.receitasapp.service.ServiceUsuario;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/Usuario")
public class UsuarioController {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping("/listarUsuarios")
    public List<UsuarioFormado> listarTodosUsuarios(){
        return serviceUsuario.listarTodosUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public UsuarioFormado encontrarUsuarioPorId(Integer idUsuario){
        return  serviceUsuario.encontrarUsuarioPorId(idUsuario);
    }

    @PostMapping
    public UsuarioFormado criar(@RequestBody UsuarioDTO usuarioDTO){
        return serviceUsuario.criarUsuario(usuarioDTO);
    }

    @PutMapping("{idUsuario")
    public UsuarioFormado atualizarUsuario(@PathVariable("idUsuario") Integer idUsuario,
                                           @RequestBody UsuarioDTO usuarioAtualizar){
        return serviceUsuario.atualizarUsuario(usuarioAtualizar, idUsuario);
    }

    @DeleteMapping("{idUsuario")
    public UsuarioFormado deletarUsuario(@PathVariable ("idUsuario") Integer idUsuario){
        return serviceUsuario.deletarUsuario(idUsuario);
    }




}
