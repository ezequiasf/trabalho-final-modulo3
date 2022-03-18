package com.dbccompany.receitasapp.repository;

import com.dbccompany.receitasapp.entity.Nota;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.utils.Validar;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class RepositorioNota implements RepositorioGenerico<Nota, Integer>, Validar<Nota, Integer> {

    private final List<Nota> notasBanco = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public RepositorioNota() {
        Nota n1 = Nota.builder()
                .idNota(COUNTER.incrementAndGet())
                .idReceita(1)
                .idUsuario(1)
                .classificacao(new BigDecimal("3.2")).build();
        Nota n2 = Nota.builder()
                .idNota(COUNTER.incrementAndGet())
                .idReceita(2)
                .idUsuario(1)
                .classificacao(new BigDecimal("4.5")).build();
        notasBanco.add(n1);
        notasBanco.add(n2);
    }

    @Override
    public List<Nota> lerTodos() {
        return notasBanco;
    }

    @Override
    public Nota encontrarPorId(Integer idNota) throws ObjetoNaoEncontradoException {
        return seExistirRetorne(idNota);
    }

    @Override
    public Nota salvar(Nota nota) {
        nota.setIdNota(COUNTER.incrementAndGet());
        notasBanco.add(nota);
        return nota;
    }

    @Override
    public Nota atualizar(Nota nota, Integer idNota) throws ObjetoNaoEncontradoException {
        Nota n = seExistirRetorne(idNota);
        n.setClassificacao(nota.getClassificacao());
        return n;
    }

    @Override
    public Nota deletar(Integer idNota) throws ObjetoNaoEncontradoException {
        Nota n = seExistirRetorne(idNota);
        notasBanco.remove(idNota.intValue());
        return n;
    }

    @Override
    public Nota seExistirRetorne(Integer idNota) throws ObjetoNaoEncontradoException {
        return notasBanco.stream().filter(nota -> nota.getIdNota().equals(idNota))
                .findFirst()
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Nota não encontrada no banco."));
    }

    public List<Nota> encontrarNotasReceita(Integer idReceita) throws ObjetoNaoEncontradoException {
        Validar<List<Nota>, Integer> encontrarReceita = id -> {
            List<Nota> notas = notasBanco.stream()
                    .filter(nota -> nota.getIdReceita().equals(id))
                    .collect(Collectors.toList());
            if (notas.isEmpty()) {
                throw new ObjetoNaoEncontradoException("A receita informada ainda não tem nenhuma classificação.");
            }
            return notas;
        };
        return encontrarReceita.seExistirRetorne(idReceita);
    }
}
