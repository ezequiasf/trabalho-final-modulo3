package com.dbccompany.receitasapp.repository;

import com.dbccompany.receitasapp.entity.Ingrediente;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RepositorioIngrediente implements RepositorioGenerico<Ingrediente, Integer> {

    private final List<Ingrediente> ingredientesBanco = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public RepositorioIngrediente() {
        Ingrediente i1 = Ingrediente.builder()
                .id(COUNTER.incrementAndGet())
                .idReceita(2)
                .nome("Ovo")
                .quantidade("2 un")
                .build();
        Ingrediente i2 = Ingrediente.builder()
                .id(COUNTER.incrementAndGet())
                .idReceita(2)
                .nome("Pão")
                .quantidade("1 un")
                .build();
        Ingrediente i3 = Ingrediente.builder()
                .id(COUNTER.incrementAndGet())
                .idReceita(1)
                .nome("Camarão")
                .quantidade("15 un")
                .build();
        Ingrediente i4 = Ingrediente.builder()
                .id(COUNTER.incrementAndGet())
                .idReceita(1)
                .nome("Alho")
                .quantidade("2 un")
                .build();
        ingredientesBanco.addAll(Arrays.asList(i1,i2,i3,i4));
    }

    @Override
    public List<Ingrediente> lerTodos() {
        return null;
    }

    @Override
    public Ingrediente encontrarPorId(Integer integer) throws ObjetoNaoEncontradoException {
        return null;
    }

    @Override
    public Ingrediente salvar(Ingrediente ingrediente) {
        return null;
    }

    @Override
    public Ingrediente atualizar(Ingrediente ingrediente, Integer integer) throws ObjetoNaoEncontradoException {
        return null;
    }

    @Override
    public Ingrediente deletar(Integer integer) throws ObjetoNaoEncontradoException {
        return null;
    }
}
