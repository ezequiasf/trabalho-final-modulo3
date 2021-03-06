package com.dbccompany.receitasapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComentarioDTO {
    @NotNull(message = "O id da receita deve ser informado.")
    private Integer idReceita;

    @NotBlank(message = "O comentário deve ser informado.")
    @Size(min = 1, max = 200, message = "O comentário deve ter no mínimo 1 caracter e no máximo 200.")
    private String comentario;
}
