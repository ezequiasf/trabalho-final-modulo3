package com.dbccompany.receitasapp.service;
import com.dbccompany.receitasapp.dto.ReceitaDTO;
import com.dbccompany.receitasapp.dto.ReceitaFormada;
import com.dbccompany.receitasapp.repository.RepositorioReceita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private RepositorioReceita repositorioReceita;

//    private final Mapper<ReceitaDTO> mapper = new Mapper<>();

    public List<ReceitaFormada> listarTodasReceitas(){
//        return mapper.converterLista(repositorioReceita.lerTodos(), ReceitaDTO.class);
return null;
    }

    public ReceitaFormada listarReceitaPorId(){
        return null;
    }
    public List<ReceitaFormada> listarReceitarPorUsuario(Integer id){
        return null;
    }

    public ReceitaFormada criar(ReceitaDTO receitaDTO){
        return null;
    }

    public ReceitaFormada atualizarReceita(ReceitaDTO receitaDTO, Integer idReceita){
        return null;
    }

    public ReceitaFormada deletarReceita(Integer idReceita){
        return null;
    }


}
