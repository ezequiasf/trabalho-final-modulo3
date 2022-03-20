package com.dbccompany.receitasapp.dtoClient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaClienteDTO {
    private String label;
    private String urlImg;
    private String[] dietLabels;
    private String[] healthLabels;
    private String[] ingredients;
    private BigDecimal calories;
    private String mealType;
}
