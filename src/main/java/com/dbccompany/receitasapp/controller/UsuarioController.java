package com.dbccompany.receitasapp.controller;


import com.dbccompany.receitasapp.dto.UsuarioDTO;
import com.dbccompany.receitasapp.dto.UsuarioFormado;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService serviceUsuario;

    @GetMapping("/listarUsuarios")
    public List<UsuarioFormado> listarTodosUsuarios() {
        return serviceUsuario.listarTodosUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public UsuarioFormado encontrarUsuarioPorId(@PathVariable("idUsuario") Integer idUsuario) throws ObjetoNaoEncontradoException {
        return serviceUsuario.encontrarUsuarioPorId(idUsuario);
    }

    @PostMapping("/salvar")
    @Validated
    public UsuarioFormado salvarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return serviceUsuario.salvarUsuario(usuarioDTO);
    }

    @PutMapping("/atualizar/{idUsuario}")
    @Validated
    public UsuarioFormado atualizarUsuario(@PathVariable("idUsuario") Integer idUsuario,
                                           @Valid @RequestBody UsuarioDTO usuarioAtualizar) throws ObjetoNaoEncontradoException {
        return serviceUsuario.atualizarUsuario(usuarioAtualizar, idUsuario);
    }

    @DeleteMapping("/deletar/{idUsuario}")
    public UsuarioFormado deletarUsuario(@PathVariable("idUsuario") Integer idUsuario) throws ObjetoNaoEncontradoException {
        return serviceUsuario.deletarUsuario(idUsuario);
    }

}
