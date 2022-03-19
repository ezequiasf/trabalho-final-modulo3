package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.ReceitaDTO;
import com.dbccompany.receitasapp.dto.ReceitaFormada;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.ReceitaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @ApiOperation(value = "Retorna uma lista de receitas registradas.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "As receitas foram listadas com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema."),})
    @GetMapping("/listarReceitas")
    public List<ReceitaFormada> listarTodasReceitas() {
        return receitaService.listarTodasReceitas();
    }

    @ApiOperation(value = "Encontra uma receita registrada através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "A receita foi informada com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/{idReceita}")
    public ReceitaFormada listarReceitaPorId(@PathVariable("idReceita") Integer idReceita) throws ObjetoNaoEncontradoException {
        return receitaService.encontrarPorId(idReceita);
    }

    @ApiOperation(value = "Encontra receitas a partir de um id de usuário informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "As receitas foram informadas com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/usuario/{idUsuario}")
    public List<ReceitaFormada> listarReceitasPorUsuario(@PathVariable("idUsuario") Integer idUsuario) throws ObjetoNaoEncontradoException {
        return receitaService.listarReceitarPorUsuario(idUsuario);
    }

    @ApiOperation(value = "Cadastra uma receita no banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Cadastrou a receita com sucesso no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping("/salvar/{idUsuario}")
    @Validated
    public ReceitaFormada salvarReceita(@Valid @RequestBody ReceitaDTO receitaDTO, @PathVariable("idUsuario") Integer idUsuario) {
        return receitaService.salvarReceita(receitaDTO, idUsuario);
    }

    @ApiOperation(value = "Atualiza uma receita no banco de dados através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Atualizou com sucesso a receita no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/atualizar/{idReceita}")
    @Validated
    public ReceitaFormada atualizarReceita(@PathVariable("idReceita") Integer idReceita,
                                           @Valid @RequestBody ReceitaDTO receitaAtualizar) throws ObjetoNaoEncontradoException {
        return receitaService.atualizarReceita(receitaAtualizar, idReceita);
    }

    @ApiOperation(value = "Deleta uma receita do banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deletou a receita com sucesso do banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/deletar/{idReceita}")
    public ReceitaFormada deletarReceita(@PathVariable("idReceita") Integer idReceita) throws ObjetoNaoEncontradoException {
        return receitaService.deletarReceita(idReceita);
    }

}
