package br.com.fam.servico;

import br.com.fam.modelo.DadosAgenda;
import br.com.fam.util.TelaUtil;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class OrdenaDados {
    public static List<DadosAgenda> ordenar(List<DadosAgenda> dadosAgenda) {

        if (dadosAgenda.isEmpty()) {
            TelaUtil.aprensentarMensagem("Sem dados para ordernar");
            return Collections.emptyList();
        }

        dadosAgenda.sort(comparing(DadosAgenda::getNome)); // faz a ordenação pelo método getNome (lexicograficamente)

        return dadosAgenda;
    }
}
