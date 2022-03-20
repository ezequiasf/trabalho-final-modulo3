package com.dbccompany.receitasapp.utils;

import com.dbccompany.receitasapp.dtoClient.ReceitaClienteDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class GerarReceita {

    // [ {recipe, links}  , {}, {}... ]
    public static List<ReceitaClienteDTO> gerarLista (Map<String,Object> jsonResponse){
        JSONObject jsonReceita = new JSONObject(jsonResponse);
        List<ReceitaClienteDTO> receitas = new ArrayList<>();


        JSONArray arrayReceitas = jsonReceita.getJSONArray("hits");


        Iterator<Object> receitasIterador = arrayReceitas.iterator();
        while (receitasIterador.hasNext()){
            Object o = receitasIterador.next();
//            LinkedHashMap<String,Object> map = (LinkedHashMap<String,Object>) receitasIterador.next()
        }


        return receitas;
    }
}
