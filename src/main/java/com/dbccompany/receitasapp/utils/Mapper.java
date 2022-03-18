package com.dbccompany.receitasapp.utils;

import com.dbccompany.receitasapp.dto.DTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper<T extends DTO, L> {

    @Autowired
    private ObjectMapper mapper;

    public DTO converterObjeto(L objetoConverter, T objetoAlvo){
        return mapper.convertValue(objetoConverter, objetoAlvo.getClass());
    }

    public List<? extends DTO> converterLista (List<L> listaConverter, T tipoAlvo){
        return listaConverter.stream()
                    .map(l-> mapper.convertValue(l, tipoAlvo.getClass()))
                    .collect(Collectors.toList());
    }
}
