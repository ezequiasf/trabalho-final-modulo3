package com.dbccompany.receitasapp.utils;

import com.dbccompany.receitasapp.dtoClient.ReceitaClienteDTO;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GerarReceita {

    public List<ReceitaClienteDTO> gerarLista(Map<String, Object> jsonResponse) {

        JSONObject jsonTotal = new JSONObject(jsonResponse);
        List<ReceitaClienteDTO> receitas = new ArrayList<>();
        JSONArray arrHits = jsonTotal.getJSONArray("hits");

        for (int i = 0; i < arrHits.toList().size(); i++) {
            JSONObject objTodo = arrHits.getJSONObject(i);
            JSONObject recipeObj = objTodo.getJSONObject("recipe");
            ReceitaClienteDTO dto = ReceitaClienteDTO.builder()
                    .label(recipeObj.getString("label"))
                    .image(recipeObj.getString("image"))
                    .calories(BigDecimal.valueOf(recipeObj.getDouble("calories")))
                    .mealType(convertJSONArray(recipeObj.getJSONArray("mealType")))
                    .ingredientLines(convertJSONArray(recipeObj.getJSONArray("ingredientLines")))
                    .dietLabels(convertJSONArray(recipeObj.getJSONArray("dietLabels")))
                    .healthLabels(convertJSONArray(recipeObj.getJSONArray("healthLabels")))
                    .build();
            receitas.add(dto);
        }
        return receitas;
    }

    private List<String> convertJSONArray(JSONArray arr) {
        return arr.toList().stream().map(obj -> (String) obj)
                .collect(Collectors.toList());
    }
}
