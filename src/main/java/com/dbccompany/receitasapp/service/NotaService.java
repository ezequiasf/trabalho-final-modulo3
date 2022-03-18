package com.dbccompany.receitasapp.service;

import com.dbccompany.receitasapp.dto.NotaDTO;
import com.dbccompany.receitasapp.dto.NotaFormada;
import com.dbccompany.receitasapp.entity.Nota;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.repository.RepositorioNota;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NotaService {

    @Autowired
    private RepositorioNota repositorioNota;

    @Autowired
    private ObjectMapper objectMapper;

    public List<NotaFormada> lerTodasNotas (){
        log.info("Chamada de método service:: Ler todas as notas.");
        return converterLista(repositorioNota.lerTodos());
    }

    public NotaFormada encontrarPorId (Integer idNota) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Encontrar por id.");
        Nota n = repositorioNota.encontrarPorId(idNota);
        log.info("Feita verificação do ID.");
        return objectMapper.convertValue(n, NotaFormada.class);
    }

    public NotaFormada salvar (NotaDTO notaDTO, Integer idUsuario){
        log.info("Chamada de método service:: Salvar notas.");
        Nota n = objectMapper.convertValue(notaDTO, Nota.class);
        log.info("Objeto DTO convertido para tipo Nota.");
        n.setIdUsuario(idUsuario);
        Nota n2 = repositorioNota.salvar(n);
        log.info("Nota salva no repositório.");
        return objectMapper.convertValue(n2, NotaFormada.class);
    }

    public NotaFormada atualizar (NotaDTO notaDTO, Integer idNota) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Atualizar notas.");
        Nota n = objectMapper.convertValue(notaDTO, Nota.class);
        log.info("Objeto DTO convertido para tipo Nota.");
        Nota n2 = repositorioNota.atualizar(n, idNota);
        log.info("Nota atualizada no repositório.");
        return objectMapper.convertValue(n2, NotaFormada.class);
    }

    public NotaFormada deletar (Integer idNota) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Deletar notas.");
        Nota n = repositorioNota.deletar(idNota);
        log.info("Nota deletada no repositório.");
        return objectMapper.convertValue(n, NotaFormada.class);
    }

    public List<NotaFormada> encontrarNotasReceita (Integer idReceita) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Encontrar notas por receita.");
        return converterLista(repositorioNota.encontrarNotasReceita(idReceita));
    }

    private List<NotaFormada> converterLista(List<Nota> notas) {
        log.info("Iniciando conversão de lista...");
        return notas
                .stream()
                .map(nota -> objectMapper.convertValue(nota, NotaFormada.class))
                .collect(Collectors.toList());
    }
}
