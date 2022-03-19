package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.IngredienteDTO;
import com.dbccompany.receitasapp.dto.IngredienteFormado;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/lerTodos")
    public List<IngredienteFormado> listarIngredientes() {
        return ingredienteService.lerTodosIngredientes();
    }

    @GetMapping("/{idIngrediente}")
    public IngredienteFormado encontrarPorId(@PathVariable("idIngrediente") Integer idIngrediente)
            throws ObjetoNaoEncontradoException {
        return ingredienteService.encontrarPorId(idIngrediente);
    }

    @PostMapping("/salvar/{idReceita}")
    public IngredienteFormado salvarIngrediente(@Valid @RequestBody IngredienteDTO ingDto
            , @PathVariable("idReceita") Integer idReceita) {
        return ingredienteService.salvarIngrediente(ingDto, idReceita);
    }

    @PutMapping("/atualizar/{idIngrediente}")
    public IngredienteFormado atualizarIngrediente(@Valid @RequestBody IngredienteDTO ingDto
            , @PathVariable("idIngrediente") Integer idIngrediente) throws ObjetoNaoEncontradoException {
        return ingredienteService.atualizarIngrediente(ingDto, idIngrediente);
    }

    @DeleteMapping("/deletar/{idIngrediente}")
    public IngredienteFormado deletarIngrediente(@PathVariable("idIngrediente") Integer idIng) throws ObjetoNaoEncontradoException {
        return ingredienteService.deletar(idIng);
    }
}
