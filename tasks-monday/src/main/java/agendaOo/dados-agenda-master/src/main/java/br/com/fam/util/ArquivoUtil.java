package br.com.fam.util;

import java.io.File;

public class ArquivoUtil {

    private static final String diretorioBase = "/home/ndeitch/git/personal/dados-agenda/src/main/resources/";

    private ArquivoUtil() {}

    public static File getArquivo(boolean isEntrada) {
        if (isEntrada)
            return new File(diretorioBase + "entrada.txt");

        return new File(diretorioBase + "saida.txt");
    }
}
