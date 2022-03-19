package com.dbccompany.receitasapp.repository;

import com.dbccompany.receitasapp.entity.Usuario;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.utils.Validar;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RepositorioUsuario implements RepositorioGenerico<Usuario, Integer>, Validar<Usuario, Integer> {

    private final List<Usuario> usuariosBanco = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public RepositorioUsuario() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Usuario u1 = Usuario.builder().id(COUNTER.incrementAndGet())
                .nomeUsuario("Marcos Almeida")
                .senha("534642#@")
                .email("Marcos12@gmail.com")
                .dataNascimento(LocalDate.parse("10/10/2000", formatter)).build();

        Usuario u2 = Usuario.builder().id(COUNTER.incrementAndGet())
                .nomeUsuario("Carlos Sales")
                .senha("reTru$###@!")
                .email("carlitostevez@gmail.com")
                .dataNascimento(LocalDate.parse("15/01/2010", formatter)).build();
        usuariosBanco.add(u1);
        usuariosBanco.add(u2);
    }

    @Override
    public List<Usuario> lerTodos() {
        return usuariosBanco;
    }

    @Override
    public Usuario encontrarPorId(Integer idUser) throws ObjetoNaoEncontradoException {
        return seExistirRetorne(idUser);
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario.setId(COUNTER.incrementAndGet());
        usuariosBanco.add(usuario);
        return usuario;
    }

    @Override
    public Usuario atualizar(Usuario usuarioNovo, Integer idUser) throws ObjetoNaoEncontradoException {
        Usuario usuarioExistente = seExistirRetorne(idUser);
        usuarioExistente.setNomeUsuario(usuarioNovo.getNomeUsuario());
        usuarioExistente.setSenha(usuarioNovo.getSenha());
        usuarioExistente.setEmail(usuarioNovo.getEmail());
        usuarioExistente.setDataNascimento(usuarioNovo.getDataNascimento());
        return usuarioExistente;
    }

    @Override
    public Usuario deletar(Integer idUser) throws ObjetoNaoEncontradoException {
        Usuario usuarioDeletado = seExistirRetorne(idUser);
        usuariosBanco.remove(usuarioDeletado);
        return usuarioDeletado;
    }

    @Override
    public Usuario seExistirRetorne(Integer idUser) throws ObjetoNaoEncontradoException {
        return usuariosBanco.stream()
                .filter(usuario -> usuario.getId().equals(idUser))
                .findFirst()
                .orElseThrow(() -> new ObjetoNaoEncontradoException
                        ("Não foi encontrado nenhum objeto com o id informado."));
    }
}
