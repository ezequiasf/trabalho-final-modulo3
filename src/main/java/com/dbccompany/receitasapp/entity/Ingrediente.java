package com.dbccompany.receitasapp.entity;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(includeFieldNames = false)
public class Ingrediente {
    @ToString.Exclude
    private Integer id;
    @NotBlank(message = "Nome do ingrediente deve conter pelo menos um caractere.")
    @Max(value = 15, message = "Nome do ingrediente deve conter no máximo 15 caracteres.")
    private String nome;
    @NotBlank(message = "A quantidade deve conter pelo menos um caractere.")
    @Max(value = 15, message = "A quantidade deve conter no máximo 15 caracteres.")
    private String quantidade;
}
