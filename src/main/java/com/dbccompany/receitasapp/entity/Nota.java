package com.dbccompany.receitasapp.entity;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true)
public class Nota {
    private Integer idNota;
    private Integer idUsuario;
    private Integer idReceita;
    @ToString.Include
    private BigDecimal classificacao;
}
