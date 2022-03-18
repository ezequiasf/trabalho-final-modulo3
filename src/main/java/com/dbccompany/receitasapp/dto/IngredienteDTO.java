package com.dbccompany.receitasapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredienteDTO {
    @NotBlank(message = "Nome do ingrediente deve conter pelo menos um caractere.")
    @Size(min = 1, max = 15, message = "Nome do ingrediente deve conter no máximo 15 caracteres.")
    private String nome;

    @NotBlank(message = "A quantidade deve conter pelo menos um caractere.")
    @Size(min = 1, max = 15, message = "A quantidade deve conter no máximo 15 caracteres.")
    private String quantidade;
}
