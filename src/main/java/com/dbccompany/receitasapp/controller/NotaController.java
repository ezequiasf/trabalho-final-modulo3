package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.NotaDTO;
import com.dbccompany.receitasapp.dto.NotaFormada;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.NotaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @ApiOperation(value = "Retorna uma lista de notas registradas.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "As notas foram listadas com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema."),})
    @GetMapping("/lerTodas")
    public List<NotaFormada> lerTodasNotas() {
        return notaService.lerTodasNotas();
    }

    @ApiOperation(value = "Encontra uma nota registrada através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "A nota foi informada com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/{idNota}")
    public NotaFormada encontrarPorId(@PathVariable("idNota") Integer idNota) throws ObjetoNaoEncontradoException {
        return notaService.encontrarPorId(idNota);
    }

    @ApiOperation(value = "Encontra notas a partir de um id de receita informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "As notas foram informadas com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/receita/{idReceita}")
    public List<NotaFormada> encontrarNotasReceita(@PathVariable("idReceita") Integer idReceita) throws ObjetoNaoEncontradoException {
        return notaService.encontrarNotasReceita(idReceita);
    }

    @ApiOperation(value = "Cadastra uma nota no banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Cadastrou a nota com sucesso no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping("/salvar/{idUsuario}")
    @Validated
    public NotaFormada salvarNota(@Valid @RequestBody NotaDTO notaDto, @PathVariable("idUsuario") Integer idUsuario) {
        return notaService.salvar(notaDto, idUsuario);
    }

    @ApiOperation(value = "Atualiza uma nota no banco de dados através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Atualizou com sucesso a nota no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/atualizar/{idNota}")
    @Validated
    public NotaFormada atualizarNota(@Valid @RequestBody NotaDTO notaDto, @PathVariable("idNota") Integer idNota) throws ObjetoNaoEncontradoException {
        return notaService.atualizar(notaDto, idNota);
    }

    @ApiOperation(value = "Deleta uma nota do banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deletou a nota com sucesso do banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/deletar/{idNota}")
    public NotaFormada deletarNota(@PathVariable("idNota") Integer idNota) throws ObjetoNaoEncontradoException {
        return notaService.deletar(idNota);
    }

}
