package com.dbccompany.receitasapp.controllerClient;

import com.dbccompany.receitasapp.client.DadosReceita;
import com.dbccompany.receitasapp.dtoClient.ReceitaClienteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/clientReceita")
@RequiredArgsConstructor
public class ReceitaControllerClient {

    @Autowired
    private DadosReceita dadosCliente;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    public LinkedHashMap<String, Object> retornaReceitasPorIng(@RequestParam String q){
        HashMap<String,String> params = new HashMap<>();
        params.put("app_id", "907ae45b");
        params.put("app_key", "4957ce0e972732121fc24e526e856d9e");
        params.put("type", "public");
        params.put("q", q);
        LinkedHashMap<String, Object> linked =  dadosCliente.recuperarReceitaPorIng(params);
        JSONObject json = new JSONObject(linked);
        System.out.println(json.getJSONObject("_links"));
        return linked;
    }
}
