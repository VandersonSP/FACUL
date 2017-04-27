package br.com.fam.servico;

import br.com.fam.modelo.DadosAgenda;
import br.com.fam.modelo.Sexo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static br.com.fam.util.ArquivoUtil.getArquivo;

public class EntradaDados {

    public static List<DadosAgenda> lerDados() {

        List<DadosAgenda> dadosAgenda = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(getArquivo(true)))) {
            for (int i = 0; i < 10; i++) {

                String nome = br.readLine();
                int telefone = Integer.parseInt(br.readLine());
                Sexo sexo = Sexo.valueOf(br.readLine().charAt(0));
                double altura = Double.parseDouble(br.readLine());

                dadosAgenda.add(new DadosAgenda(nome, telefone, sexo, altura));
            }
        } catch (IOException ioe) {
            System.err.println("Alguma coisa errada aconteceu ao ler arquivo -> " + ioe.getMessage());
        }

        if (dadosAgenda.isEmpty())
            System.err.println("Nenhum dado carregado do arquivo");
        else
            System.out.println("Dados recuperados do arquivo com sucesso!");

        return dadosAgenda;
    }
}
