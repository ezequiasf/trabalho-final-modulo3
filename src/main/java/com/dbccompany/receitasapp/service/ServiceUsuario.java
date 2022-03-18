package com.dbccompany.receitasapp.service;

import com.dbccompany.receitasapp.repository.RepositorioUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;




}
