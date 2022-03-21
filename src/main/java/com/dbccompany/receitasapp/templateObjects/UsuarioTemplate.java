package com.dbccompany.receitasapp.templateObjects;


import com.dbccompany.receitasapp.dto.UsuarioDTO;
import com.dbccompany.receitasapp.enumTemplates.SituacoesUsuario;
import com.dbccompany.receitasapp.enumTemplates.TemplateSituations;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class UsuarioTemplate extends TemplateObject {

    public UsuarioTemplate(UsuarioDTO usuarioDTO) {
        HashMap<String, Object> dadosUsuario = new HashMap<>();
        dadosUsuario.put("nome", usuarioDTO.getNomeUsuario());
        dadosUsuario.put("email", usuarioDTO.getEmail());
        dadosUsuario.put("emailEmpresa", EMAIL_EMPRESA);
        this.setDADOS(dadosUsuario);
    }

    @Override
    public String getTemplate(TemplateSituations situacao) {
        return ((SituacoesUsuario) situacao).getTemplateName();
    }
}
