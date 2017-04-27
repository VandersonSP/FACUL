package br.com.fam.servico;

import br.com.fam.modelo.DadosAgenda;
import br.com.fam.util.TelaUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static br.com.fam.util.ArquivoUtil.getArquivo;

public class GravarDados {

    public static void gravar(List<DadosAgenda> dadosAgenda) {

        if (null == dadosAgenda || dadosAgenda.isEmpty()) {
            TelaUtil.aprensentarMensagem("Sem dados para gravar");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(getArquivo(false)))) {

            dadosAgenda.forEach(dado -> {
                try {
                    bw.write(dado.getNome());
                    bw.newLine();
                    bw.write(String.valueOf(dado.getTelefone()));
                    bw.newLine();
                    bw.write(dado.getSexo().toString());
                    bw.newLine();
                    bw.write(String.valueOf(dado.getAltura()));
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException ioe) {
            System.err.println("Alguma coisa errada aconteceu ao escrever no arquivo -> " + ioe.getMessage());
        }

        System.out.println("Dados gravados com sucesso!");
    }
}
