package com.dbccompany.receitasapp.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(includeFieldNames = false)
public class Usuario {
    @ToString.Exclude
    private Integer id;
    private String nomeUsuario;
    private String senha;
    private LocalDate dataNascimento;
    private String email;
}
