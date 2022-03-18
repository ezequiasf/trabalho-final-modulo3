package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.NotaDTO;
import com.dbccompany.receitasapp.dto.NotaFormada;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping("/lerTodas")
    public List<NotaFormada> lerTodasNotas() {
        return notaService.lerTodasNotas();
    }

    @GetMapping("/{idNota}")
    public NotaFormada encontrarPorId(@PathVariable("idNota") Integer idNota) throws ObjetoNaoEncontradoException {
        return notaService.encontrarPorId(idNota);
    }

    @GetMapping("/receita/{idReceita}")
    public List<NotaFormada> encontrarNotasReceita(@PathVariable("idReceita") Integer idReceita) throws ObjetoNaoEncontradoException {
        return notaService.encontrarNotasReceita(idReceita);
    }

    @PostMapping("/salvar/{idUsuario}")
    public NotaFormada salvarNota(@Valid @RequestBody NotaDTO notaDto, @PathVariable("idUsuario") Integer idUsuario) {
        return notaService.salvar(notaDto, idUsuario);
    }

    @PutMapping("/atualizar/{idNota}")
    public NotaFormada atualizarNota(@Valid @RequestBody NotaDTO notaDto, @PathVariable("idNota") Integer idNota) throws ObjetoNaoEncontradoException {
        return notaService.atualizar(notaDto, idNota);
    }

    @DeleteMapping("/deletar/{idNota}")
    public NotaFormada deletarNota(@PathVariable("idNota") Integer idNota) throws ObjetoNaoEncontradoException {
        return notaService.deletar(idNota);
    }

}
