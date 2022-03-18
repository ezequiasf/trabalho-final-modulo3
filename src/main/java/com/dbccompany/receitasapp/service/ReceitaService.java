package com.dbccompany.receitasapp.service;

import com.dbccompany.receitasapp.dto.ReceitaDTO;
import com.dbccompany.receitasapp.dto.ReceitaFormada;
import com.dbccompany.receitasapp.entity.Receita;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.repository.RepositorioReceita;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReceitaService {

    @Autowired
    private RepositorioReceita repositorioReceita;

    @Autowired
    private ObjectMapper objectMapper;

    public List<ReceitaFormada> listarTodasReceitas() {
        return converterLista(repositorioReceita.lerTodos());
    }

    public ReceitaFormada encontrarPorId(Integer idReceita) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Encontrar por id.");
        Receita r = repositorioReceita.encontrarPorId(idReceita);
        log.info("Feita verificação do ID.");
        return objectMapper.convertValue(r, ReceitaFormada.class);
    }

    public List<ReceitaFormada> listarReceitarPorUsuario(Integer idUsuario) throws ObjetoNaoEncontradoException {
        return converterLista(repositorioReceita.encontrarPorUsuario(idUsuario));
    }

    public ReceitaFormada salvarReceita(ReceitaDTO receitaDTO, Integer idUsuario) {
        log.info("Chamada de método service:: Salvar receitas.");
        Receita r = objectMapper.convertValue(receitaDTO, Receita.class);
        log.info("Objeto DTO convertido para tipo Receita.");
        r.setIdUsuario(idUsuario);
        Receita r2 = repositorioReceita.salvar(r);
        log.info("Receita salva no repositório.");
        return objectMapper.convertValue(r2, ReceitaFormada.class);
    }

    public ReceitaFormada atualizarReceita(ReceitaDTO receitaDTO, Integer idReceita) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Atualizar receitas.");
        Receita r = objectMapper.convertValue(receitaDTO, Receita.class);
        log.info("Objeto DTO convertido para tipo Receita.");
        Receita r2 = repositorioReceita.atualizar(r, idReceita);
        log.info("Receita atualizada no repositório.");
        return objectMapper.convertValue(r2, ReceitaFormada.class);
    }

    public ReceitaFormada deletarReceita(Integer idReceita) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Deletar receitas.");
        Receita r = repositorioReceita.deletar(idReceita);
        log.info("Receita deletada no repositório.");
        return objectMapper.convertValue(r, ReceitaFormada.class);
    }

    private List<ReceitaFormada> converterLista(List<Receita> receitas) {
        log.info("Iniciando conversão de lista...");
        return receitas
                .stream()
                .map(r -> objectMapper.convertValue(r, ReceitaFormada.class))
                .collect(Collectors.toList());
    }
}
