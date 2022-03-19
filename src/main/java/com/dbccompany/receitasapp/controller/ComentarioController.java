package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.ComentarioDTO;
import com.dbccompany.receitasapp.dto.ComentarioFormado;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.ComentarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @ApiOperation(value = "Retorna uma lista de comentários registrados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Os comentários foram listados com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema."),})
    @GetMapping("/lerTodos")
    public List<ComentarioFormado> lerTodosComentarios() {
        return comentarioService.lerTodosComentarios();
    }

    @ApiOperation(value = "Encontra um comentário registrado através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "O comentário foi informado com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/{idComentario}")
    public ComentarioFormado encontrarPorId(@PathVariable("idComentario") Integer idComentario) throws ObjetoNaoEncontradoException {
        return comentarioService.encontrarPorId(idComentario);
    }

    @ApiOperation(value = "Lista comentários através de uma receita.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Listou os comentários com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/receita/{idReceita}")
    public List<ComentarioFormado> encontrarCometariosReceita(@PathVariable("idReceita") Integer idReceita) throws ObjetoNaoEncontradoException {
        return comentarioService.encontrarComentariosReceita(idReceita);
    }

    @ApiOperation(value = "Cadastra um comentário no banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Cadastrou o comentário com sucesso no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping("/salvar/{idUsuario}")
    @Validated
    public ComentarioFormado salvarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO, @PathVariable("idUsuario") Integer idUsuario) {
        return comentarioService.salvar(comentarioDTO, idUsuario);
    }

    @ApiOperation(value = "Atualiza um comentário no banco de dados através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Atualizou com sucesso o comentário no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/atualizar/{idComentario}")
    @Validated
    public ComentarioFormado atualizarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO, @PathVariable("idComentario") Integer idComentario) throws ObjetoNaoEncontradoException {
        return comentarioService.atualizar(comentarioDTO, idComentario);
    }

    @ApiOperation(value = "Deleta um comentário do banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deletou o comentário com sucesso do banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/deletar/{idComentario}")
    public ComentarioFormado deletarComentario(@PathVariable("idComentario") Integer idComentario) throws ObjetoNaoEncontradoException {
        return comentarioService.deletar(idComentario);
    }

}
