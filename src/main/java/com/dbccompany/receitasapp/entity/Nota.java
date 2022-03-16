package com.dbccompany.receitasapp.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true)
public class Nota {
    private Integer idNota;

    @NotNull(message = "O id do usuário deve ser informado.")
    private Integer idUsuario;

    @NotNull(message = "O id da receita deve ser informada.")
    private Integer idReceita;

    @ToString.Include
    @NotNull(message = "A classificação deve ser informada.")
    @DecimalMax(value = "5.0", message = "O máximo da nota deve ser (5.0).")
    @DecimalMin(value = "0.0", message = "O mínimo da nota deve ser (0.0).")
    @Digits(integer = 1, fraction = 1)
    private BigDecimal classificacao;
}
