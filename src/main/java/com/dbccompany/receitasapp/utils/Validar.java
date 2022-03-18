package com.dbccompany.receitasapp.utils;

import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;

@FunctionalInterface
public interface Validar<T,U> {
    T seExistirRetorne (U u) throws ObjetoNaoEncontradoException;
}
