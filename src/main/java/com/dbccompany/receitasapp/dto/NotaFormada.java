package com.dbccompany.receitasapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaFormada extends NotaDTO{
    private Integer idNota;
    private Integer idUsuario;
}
