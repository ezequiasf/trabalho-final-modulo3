package com.dbccompany.receitasapp.controllerClient;

import com.dbccompany.receitasapp.dtoClient.ReceitaClienteDTO;
import com.dbccompany.receitasapp.serviceClient.ReceitaServiceClient;
import com.dbccompany.receitasapp.utils.GerarReceita;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/clientReceita")
@RequiredArgsConstructor
public class ReceitaControllerClient {

    @Autowired
    private ReceitaServiceClient receitaServiceClient;

    @GetMapping
    public List<ReceitaClienteDTO> retornaReceitasPorIng(@RequestParam String q) {
        LinkedHashMap<String, Object> linked = receitaServiceClient.retornaReceitaPorIng(q);
        GerarReceita gerador = new GerarReceita();
        return gerador.gerarLista(linked);
    }
}
