package com.dbccompany.receitasapp.dtoClient;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaClienteDTO {
    private String label;
    private String image;
    private List<String> dietLabels;
    private List<String> healthLabels;
    private List<String> ingredientLines;
    private BigDecimal calories;
    private List<String> mealType;
}
