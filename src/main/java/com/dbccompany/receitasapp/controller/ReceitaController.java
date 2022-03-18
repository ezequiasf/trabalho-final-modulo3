package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.ReceitaDTO;
import com.dbccompany.receitasapp.dto.ReceitaFormada;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/listarReceitas")
    public List<ReceitaFormada> listarTodasReceitas() {
        return receitaService.listarTodasReceitas();
    }

    @GetMapping("/{idReceita}")
    public ReceitaFormada listarReceitaPorId(@PathVariable("idReceita") Integer idReceita) throws ObjetoNaoEncontradoException {
        return receitaService.encontrarPorId(idReceita);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<ReceitaFormada> listarReceitasPorUsuario(@PathVariable("idUsuario") Integer idUsuario) throws ObjetoNaoEncontradoException {
        return receitaService.listarReceitarPorUsuario(idUsuario);
    }

    @PostMapping("/salvar/{idUsuario}")
    public ReceitaFormada salvarReceita(@Valid @RequestBody ReceitaDTO receitaDTO,@PathVariable("idUsuario") Integer idUsuario) {
        return receitaService.salvarReceita(receitaDTO, idUsuario);
    }

    @PutMapping("/atualizar/{idReceita}")
    public ReceitaFormada atualizarReceita(@PathVariable("idReceita") Integer idReceita,
                                           @Valid @RequestBody ReceitaDTO receitaAtualizar) throws ObjetoNaoEncontradoException {
        return receitaService.atualizarReceita(receitaAtualizar, idReceita);
    }

    @DeleteMapping("/deletar/{idReceita}")
    public ReceitaFormada deletarReceita(@PathVariable("idReceita") Integer idReceita) throws ObjetoNaoEncontradoException {
        return receitaService.deletarReceita(idReceita);
    }


}
