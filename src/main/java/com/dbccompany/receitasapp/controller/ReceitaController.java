package com.dbccompany.receitasapp.controller;

import com.dbccompany.receitasapp.dto.ReceitaDTO;
import com.dbccompany.receitasapp.dto.ReceitaFormada;
import com.dbccompany.receitasapp.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/Receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/listarReceitas")
    public List<ReceitaFormada> listarTodasReceitas(){
        return receitaService.listarTodasReceitas();
    }

    @GetMapping("/{idReceita}")
    public ReceitaFormada listarReceitaPorId(){
        return receitaService.listarReceitaPorId();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<ReceitaFormada> listarReceitasPorUsuario(Integer idUsuario){
        return receitaService.listarReceitarPorUsuario(idUsuario);
    }

    @PostMapping
    public ReceitaFormada criar(@RequestBody ReceitaDTO receitaDTO){
        return receitaService.criar(receitaDTO);
    }

    @PutMapping("/{idReceita}")
    public ReceitaFormada atualizarReceita(@PathVariable ("idReceita") Integer idReceita,
                                           @RequestBody ReceitaDTO receitaAtualizar){
        return receitaService.atualizarReceita(receitaAtualizar, idReceita);
    }

    @DeleteMapping("/{idReceita}")
    public ReceitaFormada deletarReceita(@PathVariable ("idReceita") Integer idReceita){
        return receitaService.deletarReceita(idReceita);
    }











}
