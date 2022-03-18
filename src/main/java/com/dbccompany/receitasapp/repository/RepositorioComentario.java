package com.dbccompany.receitasapp.repository;

import com.dbccompany.receitasapp.entity.Comentario;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.utils.Validar;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class RepositorioComentario implements RepositorioGenerico<Comentario, Integer>, Validar<Comentario, Integer> {

    private final List<Comentario> comentariosBanco = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public RepositorioComentario() {
        Comentario c1 = Comentario.builder()
                .idComentario(COUNTER.incrementAndGet())
                .idReceita(2)
                .idUsuario(1)
                .comentario("Uma delícia esta receita!")
                .build();
        Comentario c2 = Comentario.builder()
                .idComentario(COUNTER.incrementAndGet())
                .idReceita(1)
                .idUsuario(2)
                .comentario("Bom demaaaaaaaaais!")
                .build();
        comentariosBanco.add(c1);
        comentariosBanco.add(c2);
    }

    @Override
    public List<Comentario> lerTodos() {
        return comentariosBanco;
    }

    @Override
    public Comentario encontrarPorId(Integer idComentario) throws ObjetoNaoEncontradoException {
        return seExistirRetorne(idComentario);
    }

    @Override
    public Comentario salvar(Comentario comentario) {
        comentario.setIdComentario(COUNTER.incrementAndGet());
        comentariosBanco.add(comentario);
        return comentario;
    }

    @Override
    public Comentario atualizar(Comentario comentario, Integer idComentario) throws ObjetoNaoEncontradoException {
        Comentario c = seExistirRetorne(idComentario);
        c.setComentario(comentario.getComentario());
        return c;
    }

    @Override
    public Comentario deletar(Integer idComentario) throws ObjetoNaoEncontradoException {
        Comentario c = seExistirRetorne(idComentario);
        comentariosBanco.remove(idComentario.intValue());
        return c;
    }

    @Override
    public Comentario seExistirRetorne(Integer idComentario) throws ObjetoNaoEncontradoException {
        return comentariosBanco.stream()
                .filter(c -> c.getIdComentario().equals(idComentario))
                .findFirst()
                .orElseThrow(() -> new ObjetoNaoEncontradoException("O comentário informado não existe."));
    }

    public List<Comentario> encontrarComentariosReceita(Integer idReceita) throws ObjetoNaoEncontradoException {
        Validar<List<Comentario>, Integer> receitas = id -> {
            List<Comentario> comentarios = comentariosBanco.stream()
                    .filter(c -> c.getIdReceita().equals(id))
                    .collect(Collectors.toList());
            if (comentarios.isEmpty()) {
                throw new ObjetoNaoEncontradoException("A receita informa ainda não foi comentada ou não existe.");
            }
            return comentarios;
        };
        return receitas.seExistirRetorne(idReceita);
    }
}
