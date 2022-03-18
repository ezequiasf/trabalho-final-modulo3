package com.dbccompany.receitasapp.service;

import com.dbccompany.receitasapp.dto.UsuarioDTO;
import com.dbccompany.receitasapp.dto.UsuarioFormado;
import com.dbccompany.receitasapp.entity.Usuario;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.repository.RepositorioUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsuarioService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private ObjectMapper objectMapper;

    public List<UsuarioFormado> listarTodosUsuarios() {
        return converterLista(repositorioUsuario.lerTodos());
    }

    public UsuarioFormado encontrarUsuarioPorId(Integer idUsario) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Encontrar por id.");
        Usuario u = repositorioUsuario.encontrarPorId(idUsario);
        log.info("Feita verificação do ID.");
        return objectMapper.convertValue(u, UsuarioFormado.class);
    }

    public UsuarioFormado salvarUsuario(UsuarioDTO usuarioDTO) {
        log.info("Chamada de método service:: Salvar usuários.");
        Usuario u = objectMapper.convertValue(usuarioDTO, Usuario.class);
        log.info("Objeto DTO convertido para tipo Usuario.");
        Usuario u2 = repositorioUsuario.salvar(u);
        log.info("Usuário salvo no repositório.");
        return objectMapper.convertValue(u2, UsuarioFormado.class);
    }

    public UsuarioFormado atualizarUsuario(UsuarioDTO usuarioDTO, Integer idUsuario) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Atualizar usuários.");
        Usuario u = objectMapper.convertValue(usuarioDTO, Usuario.class);
        log.info("Objeto DTO convertido para tipo Usuario.");
        Usuario u2 = repositorioUsuario.atualizar(u, idUsuario);
        log.info("Nota atualizada no repositório.");
        return objectMapper.convertValue(u2, UsuarioFormado.class);
    }

    public UsuarioFormado deletarUsuario(Integer idUsuario) throws ObjetoNaoEncontradoException {
        log.info("Chamada de método service:: Deletar usuários.");
        Usuario u = repositorioUsuario.deletar(idUsuario);
        log.info("Nota deletada no repositório.");
        return objectMapper.convertValue(u, UsuarioFormado.class);
    }

    private List<UsuarioFormado> converterLista(List<Usuario> usuarios) {
        log.info("Iniciando conversão de lista...");
        return usuarios
                .stream()
                .map(u -> objectMapper.convertValue(u, UsuarioFormado.class))
                .collect(Collectors.toList());
    }

}
