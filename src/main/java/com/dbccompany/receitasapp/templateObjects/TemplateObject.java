package com.dbccompany.receitasapp.templateObjects;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
public abstract class TemplateObject {
    private HashMap<String,Object> DADOS = new HashMap<>();
    public abstract String getTemplate(TemplateSituations situacao);
}
