package com.dbccompany.receitasapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceitaDTO {
    private String tipoReceita;
    private String tipoRefeicao;
    private BigDecimal mediaNota = new BigDecimal("0.0");

    @NotBlank(message = "O nome da receita deve ser informado.")
    @Size(min = 2, max = 15, message = "O nome da receita deve estar entre 2 e 15 caracteres.")
    private String nomeReceita;

    @NotBlank(message = "O modo de preparo deve ser informado.")
    @Size(min = 15, max = 300, message = "O modo de preparo deve estar entre 15 e 300 caracteres.")
    private String modoPreparo;

    @NotNull(message = "O tempo de preparo deve ser informado.")
    private Integer tempoPreparo;

    @Digits(integer = 6, fraction = 2)
    @DecimalMin(value = "0.0", message = "Não é permitido números negativos.")
    private BigDecimal mediaPreco;

    @Digits(integer = 6, fraction = 2)
    @DecimalMin(value = "0.0", message = "Não é permitido números negativos.")
    private BigDecimal calorias;

}
