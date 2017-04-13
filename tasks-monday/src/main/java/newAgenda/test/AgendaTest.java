package newAgenda.test;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AgendaTest {

    void MenuMetodTestAnaliseValorLimiteNumerico(String entrada) throws IOException {

        int cont, opcao;
//        DadosAgenda Vet[] = new DadosAgenda[10];
        String msg = "";

        for (cont = 0; cont < 10; cont = cont + 1) {
//            Vet[cont] = new DadosAgenda(" ", 0, ' ', 0.0);
        }

        msg = msg + "Digite 1 - Entrada de Dados\n";
        msg = msg + "Digite 2 - Pesquisa de Dados\n";
        msg = msg + "Digite 3 - Ordena Dados\n";
        msg = msg + "Digite 4 - Mostrar Dados\n";
        msg = msg + "Digite 5 - Gravar Dados\n";
        msg = msg + "Digite 0 - Sair do sistema.";

        do {

            //JOptionPane.showInputDialog(msg)
            opcao = Integer.parseInt(entrada);

            switch (opcao) {
                case 1:
//                    Vet = EntradaDados();//[x1
                    assertTrue(false);
                    break;
                case 2:
//                    PesquisaDados(Vet);//[x2
                    assertTrue(false);
                    break;
                case 3:
//                    Vet = OrdenaDados(Vet);//[x3//
                    assertTrue(false);
                    break;
                case 4:
//                    MostrarDados(Vet);//[x4
                    assertTrue(false);
                    break;
                case 5:
//                    GravarDados(Vet);//[x5
                    assertTrue(false);
                    break;
                case 0:
//                    System.exit(0);
                    assertTrue(false);
                default:
//                    assertTrue(true);
                    return;
//                    JOptionPane.showMessageDialog(null, "Opção inválida");

            }
        } while (opcao != 0);

        assertTrue(false);
    }

    void MenuMetodTestVazio(String entrada) throws IOException {

        int cont, opcao;
//        DadosAgenda Vet[] = new DadosAgenda[10];
        String msg = "";

        for (cont = 0; cont < 10; cont = cont + 1) {
//            Vet[cont] = new DadosAgenda(" ", 0, ' ', 0.0);
        }

        msg = msg + "Digite 1 - Entrada de Dados\n";
        msg = msg + "Digite 2 - Pesquisa de Dados\n";
        msg = msg + "Digite 3 - Ordena Dados\n";
        msg = msg + "Digite 4 - Mostrar Dados\n";
        msg = msg + "Digite 5 - Gravar Dados\n";
        msg = msg + "Digite 0 - Sair do sistema.";

        do {

            //JOptionPane.showInputDialog(msg)
            opcao = Integer.parseInt(entrada);

            switch (opcao) {
                case 1:
//                    Vet = EntradaDados();//[x1
                    assertTrue(false);
                    break;
                case 2:
//                    PesquisaDados(Vet);//[x2
                    assertTrue(false);
                    break;
                case 3:
//                    Vet = OrdenaDados(Vet);//[x3//
                    assertTrue(false);
                    break;
                case 4:
//                    MostrarDados(Vet);//[x4
                    assertTrue(false);
                    break;
                case 5:
//                    GravarDados(Vet);//[x5
                    assertTrue(false);
                    break;
                case 0:
//                    System.exit(0);
                    assertTrue(false);
                default:
                    assertNull(opcao);
//                    JOptionPane.showMessageDialog(null, "Opção inválida");

            }
        } while (opcao != 0);

        assertTrue(false);
    }

    @Test
    public void testParticionamentoClassesEquivalencia() throws Exception {

    }

    @Test
    public void testAnaliseValorLimiteVazio() throws Exception {
        int erros = 0;
        // null erro NumberFormatException não deveria acontecer
        try {
            this.MenuMetodTestVazio(null);
        } catch (Exception e) {
            erros = erros + 1;
        }

        try {
            this.MenuMetodTestVazio("");
        } catch (Exception e) {
            erros = erros + 1;
        }

        try {
            this.MenuMetodTestVazio(" ");
        } catch (Exception e) {
            erros = erros + 1;
        }
        assertEquals(0, erros);
    }

    @Test
    public void testAnaliseValorLimiteNumerico() throws Exception {
/**
 numerico 6 a 50
 e
 numerico -1 a  -50
 */
        int erros = 0;
        for (int ii = 6; ii < 50; ii++) {
            try {
                this.MenuMetodTestAnaliseValorLimiteNumerico(new Integer(ii).toString());
            } catch (Exception e) {
                erros = erros + 1;
            }
            try {
                this.MenuMetodTestAnaliseValorLimiteNumerico(new Integer(ii * -1).toString());
            } catch (Exception e) {
                erros = erros + 1;
            }
        }

        assertEquals(0, erros);
    }

    @Test
    public void testAnaliseValorLimiteString() throws Exception {
/**
 string aA-zZ.
 */
        ArrayList<String> listLetras = new ArrayList();
        listLetras.add("A");
        listLetras.add("B");
        listLetras.add("C");
        listLetras.add("D");
        listLetras.add("E");
        listLetras.add("F");
        listLetras.add("G");
        listLetras.add("H");
        listLetras.add("I");
        listLetras.add("J");
        listLetras.add("K");
        listLetras.add("L");
        listLetras.add("M");
        listLetras.add("N");
        listLetras.add("O");
        listLetras.add("P");
        listLetras.add("Q");
        listLetras.add("R");
        listLetras.add("S");
        listLetras.add("T");
        listLetras.add("U");
        listLetras.add("V");
        listLetras.add("W");
        listLetras.add("X");
        listLetras.add("Y");
        listLetras.add("Z");
        int erros = 0;
        for (int ii = 0; ii < listLetras.size(); ii++) {
            try {
                this.MenuMetodTestAnaliseValorLimiteNumerico(listLetras.get(ii));
            } catch (Exception e) {
                erros = erros + 1;
            }
            try {
                this.MenuMetodTestAnaliseValorLimiteNumerico(listLetras.get(ii).toLowerCase());
            } catch (Exception e) {
                erros = erros + 1;
            }
        }

        assertEquals(0, erros);
    }

    @Test
    public void testAnaliseValorLimiteRandon() throws Exception {
/**
 caractes de 0-100 randon;
 */
    }

    @Test
    public void testGrafoCausaEfeito() throws Exception {

    }

}