package com.dbccompany.receitasapp.serviceClient;

import com.dbccompany.receitasapp.client.DadosReceita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class ReceitaServiceClient {

    @Autowired
    private DadosReceita dadosCliente;

    public LinkedHashMap<String,Object> retornaReceitaPorIng (String q){
        HashMap<String,String> params = new HashMap<>();
        params.put("app_id", "907ae45b");
        params.put("app_key", "4957ce0e972732121fc24e526e856d9e");
        params.put("type", "public");
        params.put("q", q);
        return  dadosCliente.recuperarReceitaPorIng(params);
    }

}
