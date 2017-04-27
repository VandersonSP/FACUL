package br.com.fam.servico;

import br.com.fam.modelo.DadosAgenda;
import br.com.fam.util.TelaUtil;

import java.util.List;
import java.util.stream.Collectors;

public class PesquisaDados {
    public static void pesquisar(List<DadosAgenda> dadosAgenda) {

        if (dadosAgenda.isEmpty()) {
            TelaUtil.aprensentarMensagem("Sem dados para pesquisar");
            return;
        }

        String search = TelaUtil.lerInformacaoDaTela("Digite um nome para pesquisar");

        List<DadosAgenda> nomesEncontrados = dadosAgenda.stream()
                .filter(dado -> dado.getNome().equals(search)) // filtra os nomes iguais ao informado
                .collect(Collectors.toList());// adiciona todos em uma lista de DadosAgenda

        MostrarDados.mostrar(nomesEncontrados);
    }
}
