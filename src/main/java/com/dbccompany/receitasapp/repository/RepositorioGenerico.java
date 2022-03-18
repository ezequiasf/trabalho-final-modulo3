package com.dbccompany.receitasapp.repository;

import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;

import java.util.List;

public interface RepositorioGenerico<T,Y> {
    List<T> lerTodos ();
    T encontrarPorId (Y y) throws ObjetoNaoEncontradoException;
    T salvar (T t);
    T atualizar (T t, Y y) throws ObjetoNaoEncontradoException;
    T deletar(Y y) throws ObjetoNaoEncontradoException;
}
