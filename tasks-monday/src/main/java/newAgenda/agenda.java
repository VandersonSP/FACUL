package newAgenda;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

class DadosAgenda {
    String nome;
    int tel;
    char sexo;
    double altura;

    DadosAgenda(String n, int t, char s, double a) {
        nome = n;
        tel = t;
        sexo = s;
        altura = a;
    }

    public boolean isEmpyt() {
        boolean result = false;
        if (this.nome == " " && this.tel == 0 && this.sexo != ' ' && this.altura == 0.0) {
            result = true;
        }
        return result;
    }

}

class Agenda {

    public static ArrayList<DadosAgenda> EntradaDados() throws IOException {

        ArrayList<DadosAgenda> dados = new ArrayList<DadosAgenda>();
        boolean containsdado = true;
        FileReader Arquivo = new FileReader("C:\\Users\\vande\\Documents\\faculdade-fam\\scheduler-spring-boot\\src\\main\\java\\agenda\\entrada.txt");
        BufferedReader BArquivo = new BufferedReader(Arquivo);
        String msg = "Dados recuperados do arquivo com sucesso!";
        while (containsdado) {
            DadosAgenda newDado = new DadosAgenda(" ", 0, ' ', 0.0);

            String nome = BArquivo.readLine();
            if (nome != null) {
                newDado.nome = BArquivo.readLine();
            }

            String tel = BArquivo.readLine();
            if (tel != null) {
                newDado.tel = Integer.parseInt(BArquivo.readLine());
            }

            String sexo = BArquivo.readLine();
            if (sexo != null) {
                newDado.sexo = (sexo).charAt(0);
            }

            String altura = BArquivo.readLine();
            if (altura != null) {
                newDado.altura = Double.parseDouble(altura);
            }

            if (newDado.nome == " " && newDado.tel == 0 && newDado.sexo != ' ' && newDado.altura == 0.0) {
                containsdado = false;
            } else {
                dados.add(newDado);
            }

        }
        if (dados.isEmpty()) {
            msg = "Não tem dados para  serem recuperados do arquivo!";
        }
        BArquivo.close();
        Arquivo.close();
        System.out.println(msg);

        return dados;
    }

    public static void GravarDados(ArrayList<DadosAgenda> dados) throws IOException {
        FileWriter Arquivo = new FileWriter("C:\\Users\\vande\\Documents\\faculdade-fam\\scheduler-spring-boot\\src\\main\\java\\agenda\\saida.txt");
        BufferedWriter BArquivo = new BufferedWriter(Arquivo);
        String msg = "Não tem dados para serem gravados!";
        if (!dados.isEmpty()) {
            msg = "Dados gravados com sucesso!";
            for (DadosAgenda dado : dados) {
                if (dado != null && !dado.isEmpyt()) {
                    BArquivo.write(dado.nome);
                    BArquivo.newLine();
                    BArquivo.write(dado.tel + "");
                    BArquivo.newLine();
                    BArquivo.write(dado.sexo + "");
                    BArquivo.newLine();
                    BArquivo.write(dado.altura + "");
                    BArquivo.newLine();
                }
            }
        }

        BArquivo.close();
        Arquivo.close();
        System.out.println(msg);
    }

    public static void MostrarDados(ArrayList<DadosAgenda> dados) {
        String msg = "Não tem dados";

        if (!dados.isEmpty()) {
            msg = "";
            for (DadosAgenda dado : dados) {
                if (dado != null && !dado.isEmpyt()) {
                    msg = msg + dado.nome + " ";
                    msg = msg + dado.tel + " ";
                    msg = msg + dado.sexo + " ";
                    msg = msg + dado.altura + "\n";
                }
            }
        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public static ArrayList<DadosAgenda> OrdenaDados(ArrayList<DadosAgenda> dados) {

        String msg = "Não rem dados para serem ordenados!";

        if (!dados.isEmpty()) {
            msg = "Dados ordenados com sucesso!";

            Comparator<? super DadosAgenda> comparator = new Comparator<DadosAgenda>() {
                @Override
                public int compare(DadosAgenda o1, DadosAgenda o2) {
                    return o1.nome.compareToIgnoreCase(o2.nome);
                }
            };

            dados.sort(comparator);
        }

        System.out.println(msg);
        return dados;
    }

    public static void PesquisaDados(ArrayList<DadosAgenda> dados) {
        String nome;
        nome = JOptionPane.showInputDialog("Digite um nome a pesquisar");
        DadosAgenda var_dado = new DadosAgenda(" ", 0, ' ', 0.0);
        if (!dados.isEmpty() && !nome.isEmpty()) {
            for (DadosAgenda dado : dados) {
                if (dado != null && !dado.isEmpyt()) {
                    if (dado.nome.compareToIgnoreCase(nome) == 0) {
                        var_dado = dado;
                    }
                }
            }
        }

        if (var_dado.isEmpyt()) {
            JOptionPane.showMessageDialog(null, "não achou");
        } else {
            JOptionPane.showMessageDialog(null, var_dado.nome + " " + var_dado.tel + " " + var_dado.sexo + " " + var_dado.altura);
        }
    }

    public static void Menu() throws IOException {

        ArrayList<DadosAgenda> dados = new ArrayList<DadosAgenda>();

        int cont, opcao;
        String msg = "";
        msg = msg + "Digite 1 - Entrada de Dados\n";
        msg = msg + "Digite 2 - Pesquisa de Dados\n";
        msg = msg + "Digite 3 - Ordena Dados\n";
        msg = msg + "Digite 4 - Mostrar Dados\n";
        msg = msg + "Digite 5 - Gravar Dados\n";
        msg = msg + "Digite 0 - Sair do sistema.";

        do {
            String entrada = JOptionPane.showInputDialog(msg);
            if (entrada != null && !entrada.isEmpty()) {
                try {
                    opcao = Integer.parseInt(entrada);
                } catch (Exception e) {
                    opcao = 0;
                }
            } else {
                opcao = -1;
            }
            switch (opcao) {
                case 1:
                    dados = EntradaDados();
                    break;
                case 2:
                    if (dados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não tem dados para pesquisar\n");
                    } else {
                        PesquisaDados(dados);
                    }
                    break;
                case 3:
                    if (dados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não tem dados para ordenar\n");
                    } else {
                        dados = OrdenaDados(dados);
                    }
                    break;
                case 4:
                    if (dados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não tem dados para mostrar\n");
                    } else {
                        MostrarDados(dados);
                    }
                    break;
                case 5:
                    if (dados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não tem dados para gravar\n");
                    } else {
                        GravarDados(dados);
                    }
                    break;
                case 0:
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");

            }
        } while (opcao != 0);

    }

    public static void main(String Mari[]) throws IOException {
        Menu();
    }

}
