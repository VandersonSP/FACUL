package br.com.fam;

import br.com.fam.modelo.DadosAgenda;
import br.com.fam.servico.*;
import br.com.fam.util.TelaUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DadosAgenda> dadosAgenda = new ArrayList<>();

        int opcao;
        String msg = "";

        msg = msg + "Digite 1 - Entrada de Dados\n";
        msg = msg + "Digite 2 - Pesquisa de Dados\n";
        msg = msg + "Digite 3 - Ordena Dados\n";
        msg = msg + "Digite 4 - Mostrar Dados\n";
        msg = msg + "Digite 5 - Gravar Dados\n";
        msg = msg + "Digite 0 - Sair do sistema.";

        do {
            try {
                opcao = Integer.parseInt(TelaUtil.lerInformacaoDaTela(msg));
            } catch (NumberFormatException nfe) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    dadosAgenda = EntradaDados.lerDados();
                    break;
                case 2:
                    PesquisaDados.pesquisar(dadosAgenda);
                    break;
                case 3:
                    dadosAgenda = OrdenaDados.ordenar(dadosAgenda);
                    break;
                case 4:
                    MostrarDados.mostrar(dadosAgenda);
                    break;
                case 5:
                    GravarDados.gravar(dadosAgenda);
                    break;
                case 0:
                    System.exit(0);
                default:
                    TelaUtil.aprensentarMensagem("Opção Inválida");
            }
        } while (true);
    }
}
