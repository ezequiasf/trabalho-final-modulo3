package com.dbccompany.receitasapp.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true)
public class Comentario {
    private Integer idComentario;

    @NotNull(message = "O id usuário deve ser informado.")
    private Integer idUsuario;

    @NotNull(message = "O id da receita deve ser informado.")
    private Integer idReceita;

    @ToString.Include
    @NotBlank(message = "O comentário deve ser informado.")
    @Size(min = 1, max = 200, message = "O comentário deve ter no mínimo 1 caracter e no máximo 200.")
    private String comentario;
}
