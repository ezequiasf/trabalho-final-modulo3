package com.dbccompany.receitasapp.service;

import com.dbccompany.receitasapp.dto.ComentarioDTO;
import com.dbccompany.receitasapp.dto.ComentarioFormado;
import com.dbccompany.receitasapp.entity.Comentario;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.repository.RepositorioComentario;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ComentarioService {

    @Autowired
    private RepositorioComentario repositorioComentario;

    @Autowired
    private ObjectMapper objectMapper;

    public List<ComentarioFormado> lerTodosComentarios() {
        log.info("Chamada de método service:: Ler todas as notas.");
        return converterLista(repositorioComentario.lerTodos());
    }

    public ComentarioFormado encontrarPorId(Integer idComentario) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Encontrar por id.");
        Comentario c = repositorioComentario.encontrarPorId(idComentario);
        log.info("Feita verificação do ID.");
        return objectMapper.convertValue(c, ComentarioFormado.class);
    }

    public ComentarioFormado salvar(ComentarioDTO comentarioDTO, Integer idUsuario) {
        log.info("Chamada de método service:: Salvar comentarios.");
        Comentario c = objectMapper.convertValue(comentarioDTO, Comentario.class);
        log.info("Objeto DTO convertido para tipo Comentario.");
        c.setIdUsuario(idUsuario);
        Comentario c2 = repositorioComentario.salvar(c);
        log.info("Comentario salvo no repositório.");
        return objectMapper.convertValue(c2, ComentarioFormado.class);
    }

    public ComentarioFormado atualizar(ComentarioDTO comentarioDTO, Integer idComentario) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Atualizar comentários.");
        Comentario c = objectMapper.convertValue(comentarioDTO, Comentario.class);
        log.info("Objeto DTO convertido para tipo Comentario.");
        Comentario c2 = repositorioComentario.atualizar(c, idComentario);
        log.info("Comentário atualizado no repositório.");
        return objectMapper.convertValue(c2, ComentarioFormado.class);
    }

    public ComentarioFormado deletar(Integer idComentario) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Deletar comentários.");
        Comentario c = repositorioComentario.deletar(idComentario);
        log.info("Comentário deletado no repositório.");
        return objectMapper.convertValue(c, ComentarioFormado.class);
    }

    public List<ComentarioFormado> encontrarComentariosReceita(Integer idReceita) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Encontrar comentários por receita.");
        return converterLista(repositorioComentario.encontrarComentariosReceita(idReceita));
    }

    private List<ComentarioFormado> converterLista(List<Comentario> comentarios) {
        log.info("Iniciando conversão de lista...");
        return comentarios
                .stream()
                .map(comentario -> objectMapper.convertValue(comentario, ComentarioFormado.class))
                .collect(Collectors.toList());
    }
}
