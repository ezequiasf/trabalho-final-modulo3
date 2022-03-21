package com.dbccompany.receitasapp.repository;

import com.dbccompany.receitasapp.entity.Receita;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.utils.Validar;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class RepositorioReceita implements RepositorioGenerico<Receita, Integer>, Validar<Receita, Integer> {

    private final List<Receita> receitasBanco = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public RepositorioReceita() {
        Receita r1 = Receita.builder()
                .idReceita(COUNTER.incrementAndGet())
                .idUsuario(1)
                .nomeReceita("Camarão com fritas")
                .modoPreparo("Frita o camarão no alho e óleo.")
                .calorias(new BigDecimal("325.65"))
                .mediaPreco(new BigDecimal("32.54"))
                .mediaNota(new BigDecimal("3.5"))
                .tempoPreparo(32)
                .tipoRefeicao("Diet")
                .tipoRefeicao("Almoço")
                .build();
        Receita r2 = Receita.builder()
                .idReceita(COUNTER.incrementAndGet())
                .idUsuario(2)
                .nomeReceita("Pão com ovo")
                .modoPreparo("Frita o ovo e põe no pão.")
                .calorias(new BigDecimal("234.54"))
                .mediaPreco(new BigDecimal("4.24"))
                .mediaNota(new BigDecimal("4.6"))
                .tempoPreparo(5)
                .tipoRefeicao("Salgada")
                .tipoRefeicao("Café")
                .build();
        receitasBanco.add(r1);
        receitasBanco.add(r2);
    }

    @Override
    public List<Receita> lerTodos() {
        return receitasBanco;
    }

    @Override
    public Receita encontrarPorId(Integer idReceita) throws ObjetoNaoEncontradoException {
        return seExistirRetorne(idReceita);
    }

    @Override
    public Receita salvar(Receita receita) {
        receita.setIdReceita(COUNTER.incrementAndGet());
        receitasBanco.add(receita);
        return receita;
    }

    @Override
    public Receita atualizar(Receita receita, Integer idReceita) throws ObjetoNaoEncontradoException {
        Receita receitaDesatualizada = seExistirRetorne(idReceita);
        receitaDesatualizada.setNomeReceita(receita.getNomeReceita());
        receitaDesatualizada.setTipoReceita(receita.getTipoReceita());
        receitaDesatualizada.setCalorias(receita.getCalorias());
        receitaDesatualizada.setMediaNota(receita.getMediaNota());
        receitaDesatualizada.setModoPreparo(receita.getModoPreparo());
        receitaDesatualizada.setMediaPreco(receita.getMediaPreco());
        receitaDesatualizada.setTempoPreparo(receita.getTempoPreparo());
        return receitaDesatualizada;
    }

    @Override
    public Receita deletar(Integer idReceita) throws ObjetoNaoEncontradoException {
        Receita r = seExistirRetorne(idReceita);
        receitasBanco.remove(r);
        return r;
    }

    public List<Receita> encontrarPorUsuario(Integer idUsuario) throws ObjetoNaoEncontradoException {
        Validar<List<Receita>, Integer> validarUsuario = (id -> {
            List<Receita> receitas = receitasBanco.stream()
                    .filter(r -> r.getIdUsuario().equals(id))
                    .collect(Collectors.toList());
            if (receitas.isEmpty()) {
                throw new ObjetoNaoEncontradoException("Não existe receitas para este usuário no banco.");
            }
            return receitas;
        });
        return validarUsuario.seExistirRetorne(idUsuario);
    }

    @Override
    public Receita seExistirRetorne(Integer idReceita) throws ObjetoNaoEncontradoException {
        return receitasBanco.stream()
                .filter(receita -> receita.getIdReceita().equals(idReceita))
                .findFirst()
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Receita não encontrada no banco."));
    }
}
