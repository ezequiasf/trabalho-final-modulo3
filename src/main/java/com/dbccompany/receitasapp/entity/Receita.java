package com.dbccompany.receitasapp.entity;

import lombok.*;

import javax.validation.constraints.*;
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

    @NotNull(message = "O id do usuário deve ser informado.")
    @ToString.Include(name = "usuario")
    private Integer idUsuario;

    @NotBlank(message = "O nome da receita deve ser informado.")
    @Size(min = 2, max = 15, message = "O nome da receita deve estar entre 2 e 15 caracteres.")
    @ToString.Include(name = "Receita")
    private String nomeReceita;

    @ToString.Include(name = "receita")
    private String tipoReceita = "Não informado.";

    @ToString.Include(name = "refeição")
    private String tipoRefeicao = "Não informado";

    @NotBlank(message = "O modo de preparo deve ser informado.")
    @Size(min = 15, max = 300, message = "O nome da receita deve estar entre 15 e 300 caracteres.")
    @ToString.Include(name = "preparo")
    private String modoPreparo;

    @NotNull
    @ToString.Include(name = "tempo")
    private Integer tempoPreparo;

    @Digits(integer = 6, fraction = 2)
    @DecimalMin(value = "0.0", message = "Não é permitido números negativos.")
    @ToString.Include(name = "preço")
    private BigDecimal mediaPreco;

    @Digits(integer = 6, fraction = 2)
    @DecimalMin(value = "0.0", message = "Não é permitido números negativos.")
    private BigDecimal calorias;

    @ToString.Include(name = "classificação")
    private BigDecimal mediaNota = new BigDecimal("0.0");
}
