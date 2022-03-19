package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.IngredienteDTO;
import com.dbccompany.receitasapp.dto.IngredienteFormado;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.IngredienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @ApiOperation(value = "Retorna uma lista de ingredientes registrados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Os ingredientes foram listados com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema."),})
    @GetMapping("/lerTodos")
    public List<IngredienteFormado> listarIngredientes() {
        return ingredienteService.lerTodosIngredientes();
    }

    @ApiOperation(value = "Encontra um ingrediente registrado através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "O ingrediente foi informado com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/{idIngrediente}")
    public IngredienteFormado encontrarPorId(@PathVariable("idIngrediente") Integer idIngrediente)
            throws ObjetoNaoEncontradoException {
        return ingredienteService.encontrarPorId(idIngrediente);
    }

    @ApiOperation(value = "Cadastra um ingrediente no banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Cadastrou o ingrediente com sucesso no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping("/salvar/{idReceita}")
    public IngredienteFormado salvarIngrediente(@Valid @RequestBody IngredienteDTO ingDto
            , @PathVariable("idReceita") Integer idReceita) {
        return ingredienteService.salvarIngrediente(ingDto, idReceita);
    }

    @ApiOperation(value = "Atualiza um ingrediente no banco de dados através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Atualizou com sucesso o ingrediente no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/atualizar/{idIngrediente}")
    public IngredienteFormado atualizarIngrediente(@Valid @RequestBody IngredienteDTO ingDto
            , @PathVariable("idIngrediente") Integer idIngrediente) throws ObjetoNaoEncontradoException {
        return ingredienteService.atualizarIngrediente(ingDto, idIngrediente);
    }

    @ApiOperation(value = "Deleta um ingrediente do banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deletou o ingrediente com sucesso do banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/deletar/{idIngrediente}")
    public IngredienteFormado deletarIngrediente(@PathVariable("idIngrediente") Integer idIng) throws ObjetoNaoEncontradoException {
        return ingredienteService.deletar(idIng);
    }
}
