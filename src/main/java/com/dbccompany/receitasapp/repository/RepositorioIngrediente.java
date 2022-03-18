package com.dbccompany.receitasapp.repository;

import com.dbccompany.receitasapp.entity.Ingrediente;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.utils.Validar;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RepositorioIngrediente implements RepositorioGenerico<Ingrediente, Integer>, Validar<Ingrediente, Integer> {

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
        ingredientesBanco.addAll(Arrays.asList(i1, i2, i3, i4));
    }

    @Override
    public List<Ingrediente> lerTodos() {
        return ingredientesBanco;
    }

    @Override
    public Ingrediente encontrarPorId(Integer idIngrediente) throws ObjetoNaoEncontradoException {
        return seExistirRetorne(idIngrediente);
    }

    @Override
    public Ingrediente salvar(Ingrediente ingrediente) {
        ingrediente.setId(COUNTER.incrementAndGet());
        ingredientesBanco.add(ingrediente);
        return ingrediente;
    }

    @Override
    public Ingrediente atualizar(Ingrediente ingrediente, Integer idIngrediente) throws ObjetoNaoEncontradoException {
        Ingrediente i = seExistirRetorne(idIngrediente);
        i.setNome(ingrediente.getNome());
        i.setQuantidade(ingrediente.getQuantidade());
        return i;
    }

    @Override
    public Ingrediente deletar(Integer idIngrediente) throws ObjetoNaoEncontradoException {
        Ingrediente i = seExistirRetorne(idIngrediente);
        ingredientesBanco.remove(idIngrediente.intValue());
        return i;
    }

    @Override
    public Ingrediente seExistirRetorne(Integer idIngrediente) throws ObjetoNaoEncontradoException {
        return ingredientesBanco.stream()
                .filter(ingrediente -> ingrediente.getId().equals(idIngrediente))
                .findFirst()
                .orElseThrow(
                        () -> new ObjetoNaoEncontradoException("Não existe ingrediente registrado no banco com este id."));
    }
}
