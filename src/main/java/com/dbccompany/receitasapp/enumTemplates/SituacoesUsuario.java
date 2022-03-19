package com.dbccompany.receitasapp.enumTemplates;

import lombok.Getter;

@Getter
public enum SituacoesUsuario implements TemplateSituations{
    CADASTRO("cadastro-usuario.ftl"),
    ATUALIZAR ("atualizar-usuario.ftl"),
    EXCLUSAO ("del-usuario.ftl");
    private final String templateName;

    SituacoesUsuario(String templateName){
        this.templateName = templateName;
    }
}
