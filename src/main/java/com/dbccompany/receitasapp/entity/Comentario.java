package com.dbccompany.receitasapp.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true)
public class Comentario {
    private Integer idComentario;
    private Integer idUsuario;
    private Integer idReceita;
    @ToString.Include
    private String comentario;
}
