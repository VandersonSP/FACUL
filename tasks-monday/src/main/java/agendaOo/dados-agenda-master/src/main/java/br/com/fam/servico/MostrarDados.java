package br.com.fam.servico;

import br.com.fam.modelo.DadosAgenda;
import br.com.fam.util.TelaUtil;

import java.util.List;

public class MostrarDados {

    private static String mensagem = "";

    public static void mostrar(List<DadosAgenda> dadosAgenda) {
        mensagem = "";

        if (dadosAgenda.isEmpty()) {
            TelaUtil.aprensentarMensagem("Sem dados para mostrar");
            return;
        }

        dadosAgenda.forEach(MostrarDados::adicionarDadoAMensagem); // para cada dado, apenda o toString a mensagem

        TelaUtil.aprensentarMensagem(mensagem);
    }

    private static void adicionarDadoAMensagem(DadosAgenda dadosAgenda) {
        mensagem += dadosAgenda.toString() + "\n";
    }
}
