package com.dbccompany.receitasapp.client;

import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

//TODO: Foi gerado um email temporário para o appid e appkey
//Para gerar email de testes >>> https://www.invertexto.com/gerador-email-temporario
//Documentação da api e site para logar >> https://developer.edamam.com/

@FeignClient(value = "Receitas service API", url = "https://api.edamam.com/api/recipes/v2")
@Headers("Content-type: application/json")
public interface DadosReceita {

//    @RequestLine("GET /")
//
}
