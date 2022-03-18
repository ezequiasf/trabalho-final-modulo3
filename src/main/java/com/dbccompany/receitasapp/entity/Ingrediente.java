package com.dbccompany.receitasapp.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(includeFieldNames = false)
public class Ingrediente {
    @ToString.Exclude
    private Integer id;
    private Integer idReceita;
    private String nome;
    private String quantidade;
}
