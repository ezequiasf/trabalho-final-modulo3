package com.dbccompany.receitasapp.templateObjects;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
public abstract class TemplateObject {
    private HashMap<String,Object> DADOS = new HashMap<>();
    private final String emailEmpresa = "ezequias.barros@dbccompany.com.br";
    public abstract String getTemplate(TemplateSituations situacao);
}
