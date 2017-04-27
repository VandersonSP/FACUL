package br.com.fam.util;

import javax.swing.*;

public class TelaUtil {

    public static void aprensentarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static String lerInformacaoDaTela(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }
}
