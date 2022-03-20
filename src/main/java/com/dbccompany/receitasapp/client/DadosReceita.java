package com.dbccompany.receitasapp.client;

import com.dbccompany.receitasapp.dtoClient.ReceitaClienteDTO;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//TODO: Foi gerado um email temporário para o appid e appkey
//Para gerar email de testes >>> https://www.invertexto.com/gerador-email-temporario
//Documentação da api e site para logar >> https://developer.edamam.com/

@FeignClient(value = "Receitas", url = "https://api.edamam.com/api/recipes/v2")
@Headers("Content-type: application/json")
public interface DadosReceita {

    @RequestLine("GET /")
    LinkedHashMap<String,Object> recuperarReceitaPorIng(@QueryMap Map<String,String> params);
}
