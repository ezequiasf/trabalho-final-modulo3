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
@ToString(includeFieldNames = false)
public class Ingrediente {
    @ToString.Exclude
    private Integer id;

    @NotNull (message = "O ingrediente deve pertencer a uma receita.")
    private Integer idReceita;

    @NotBlank(message = "Nome do ingrediente deve conter pelo menos um caractere.")
    @Size(min = 1, max = 15, message = "Nome do ingrediente deve conter no máximo 15 caracteres.")
    private String nome;

    @NotBlank(message = "A quantidade deve conter pelo menos um caractere.")
    @Size(min = 1, max = 15, message = "A quantidade deve conter no máximo 15 caracteres.")
    private String quantidade;
}
