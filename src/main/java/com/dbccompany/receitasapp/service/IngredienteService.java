package com.dbccompany.receitasapp.service;

import com.dbccompany.receitasapp.dto.IngredienteDTO;
import com.dbccompany.receitasapp.dto.IngredienteFormado;
import com.dbccompany.receitasapp.entity.Ingrediente;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.repository.RepositorioIngrediente;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IngredienteService {

    @Autowired
    private RepositorioIngrediente repositorioIngrediente;

    @Autowired
    private ObjectMapper objectMapper;

    public List<IngredienteFormado> lerTodosIngredientes() {
        log.info("Chamada de método service:: Ler todas os ingredientes.");
        return converterLista(repositorioIngrediente.lerTodos());
    }

    public IngredienteFormado encontrarPorId(Integer idIngrediente) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Encontrar por id.");
        Ingrediente i = repositorioIngrediente.encontrarPorId(idIngrediente);
        log.info("Feita verificação do ID.");
        return objectMapper.convertValue(i, IngredienteFormado.class);
    }

    public IngredienteFormado salvarIngrediente(IngredienteDTO ingredienteDTO, Integer idReceita) {
        log.info("Chamada de método service:: Salvar ingredientes.");
        Ingrediente i = objectMapper.convertValue(ingredienteDTO, Ingrediente.class);
        log.info("Objeto DTO convertido para tipo Ingrediente.");
        i.setIdReceita(idReceita);
        Ingrediente i2 = repositorioIngrediente.salvar(i);
        log.info("Ingrediente salvo no repositório.");
        return objectMapper.convertValue(i2, IngredienteFormado.class);
    }

    public IngredienteFormado atualizarIngrediente(IngredienteDTO ingredienteDTO, Integer idIngrediente) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Atualizar ingredientes.");
        Ingrediente i = objectMapper.convertValue(ingredienteDTO, Ingrediente.class);
        log.info("Objeto DTO convertido para tipo Ingrediente.");
        Ingrediente i2 = repositorioIngrediente.atualizar(i, idIngrediente);
        log.info("Ingrediente atualizado no repositório.");
        return objectMapper.convertValue(i2, IngredienteFormado.class);
    }

    public IngredienteFormado deletar(Integer idIngrediente) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Deletar ingredientes.");
        Ingrediente i = repositorioIngrediente.deletar(idIngrediente);
        log.info("Ingrediente deletado do repositório.");
        return objectMapper.convertValue(i, IngredienteFormado.class);
    }


    private List<IngredienteFormado> converterLista(List<Ingrediente> ingredientes) {
        log.info("Iniciando conversão de lista...");
        return ingredientes
                .stream()
                .map(ingrediente -> objectMapper.convertValue(ingrediente, IngredienteFormado.class))
                .collect(Collectors.toList());
    }

}
