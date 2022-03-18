package com.dbccompany.receitasapp.entity;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Receita {
    @ToString.Exclude
    private Integer idReceita;

    @ToString.Include(name = "usuario")
    private Integer idUsuario;

    @ToString.Include(name = "nome")
    private String nomeReceita;

    @ToString.Include(name = "tipo")
    private String tipoReceita;

    @ToString.Include(name = "refeição")
    private String tipoRefeicao;

    @ToString.Include(name = "preparo")
    private String modoPreparo;

    @ToString.Include(name = "tempo")
    private Integer tempoPreparo;

    @ToString.Include(name = "preço")
    private BigDecimal mediaPreco;

    @ToString.Include(name = "calorias")
    private BigDecimal calorias;

    @ToString.Include(name = "classificação")
    private BigDecimal mediaNota = new BigDecimal("0.0");
}
