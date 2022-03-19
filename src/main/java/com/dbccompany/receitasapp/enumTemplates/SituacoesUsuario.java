package com.dbccompany.receitasapp.enumTemplates;

import lombok.Getter;

@Getter
public enum SituacoesUsuario implements TemplateSituations{
    CADASTRO("cadastro-usuario.ftl");

    private String templateName;

    SituacoesUsuario(String templateName){
        this.templateName = templateName;
    }
}
