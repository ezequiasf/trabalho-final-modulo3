package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.ComentarioDTO;
import com.dbccompany.receitasapp.dto.ComentarioFormado;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/lerTodos")
    public List<ComentarioFormado> lerTodosComentarios() {
        return comentarioService.lerTodosComentarios();
    }

    @GetMapping("/{idComentario}")
    public ComentarioFormado encontrarPorId(@PathVariable("idComentario") Integer idComentario) throws ObjetoNaoEncontradoException {
        return comentarioService.encontrarPorId(idComentario);
    }

    @GetMapping("/receita/{idReceita}")
    public List<ComentarioFormado> encontrarCometariosReceita(@PathVariable("idReceita") Integer idReceita) throws ObjetoNaoEncontradoException {
        return comentarioService.encontrarComentariosReceita(idReceita);
    }

    @PostMapping("/salvar/{idUsuario}")
    public ComentarioFormado salvarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO, @PathVariable("idUsuario") Integer idUsuario) {
        return comentarioService.salvar(comentarioDTO, idUsuario);
    }

    @PutMapping("/atualizar/{idComentario}")
    public ComentarioFormado atualizarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO, @PathVariable("idComentario") Integer idComentario) throws ObjetoNaoEncontradoException {
        return comentarioService.atualizar(comentarioDTO, idComentario);
    }

    @DeleteMapping("/deletar/{idComentario}")
    public ComentarioFormado deletarComentario(@PathVariable("idComentario") Integer idComentario) throws ObjetoNaoEncontradoException {
        return comentarioService.deletar(idComentario);
    }

}
