package com.dbccompany.receitasapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReceitaFormada extends ReceitaDTO {
    private Integer idReceita;
    private Integer idUsuario;
}
