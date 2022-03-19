package com.dbccompany.receitasapp.templateObjects;


import com.dbccompany.receitasapp.dto.UsuarioDTO;
import lombok.Setter;

import java.util.HashMap;

@Setter
public class UsuarioTemplate extends TemplateObject{

    private String TEMPLATE_CADASTRO = "cadastro-usuario.ftl";

    public UsuarioTemplate (UsuarioDTO usuarioDTO){
        HashMap<String,Object> dadosUsuario = new HashMap<>();
        dadosUsuario.put("nome", usuarioDTO.getNomeUsuario());
        dadosUsuario.put("email", usuarioDTO.getEmail());
        dadosUsuario.put("emailEmpresa", this.getEmailEmpresa());
        this.setDADOS(dadosUsuario);
    }

    @Override
    public String getTemplate (TemplateSituations situacao){
        String template = "";
        if (situacao == TemplateSituations.CADASTRO) {
            template = TEMPLATE_CADASTRO;
        }
        return template;
    }
}
