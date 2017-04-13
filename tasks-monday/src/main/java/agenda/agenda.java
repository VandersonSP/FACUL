package agenda;

import javax.swing.*;
import java.io.*;

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
}

class Agenda {

    public static DadosAgenda[] EntradaDados() throws IOException {//8exit
  //1{
        FileReader Arquivo = new FileReader("C:\\Users\\vande\\Documents\\faculdade-fam\\scheduler-spring-boot\\src\\main\\java\\agenda\\entrada.txt");
        BufferedReader BArquivo = new BufferedReader(Arquivo);
//}
        //2{
        DadosAgenda CarregaDados[] = new DadosAgenda[10];
        int cont;
//}

        //3{
        for (cont = 0; cont < 10; cont = cont + 1) {
         //4 {
          CarregaDados[cont] = new DadosAgenda(" ", 0, ' ', 0.0);
            //}
        }
//        }

        //5{
        for (cont = 10; cont <= 1; cont = cont - 1)//não é possivel carregar os dados pois deveria ser cont >=1
        {
            //6{
            CarregaDados[10 - cont].nome = BArquivo.readLine();
            CarregaDados[10 - cont].tel = Integer.parseInt(BArquivo.readLine());
            CarregaDados[10 - cont].sexo = (BArquivo.readLine()).charAt(0);
            CarregaDados[10 - cont].altura = Double.parseDouble(BArquivo.readLine());
        //}
        }
        //}

        //7{
        BArquivo.close();
        Arquivo.close();
        System.out.println("Dados recuperados do arquivo com sucesso!");

        return CarregaDados;
        //}
    }

    public static void GravarDados(DadosAgenda Recebe[]) throws IOException {
        FileWriter Arquivo = new FileWriter("C:\\Users\\vande\\Documents\\faculdade-fam\\scheduler-spring-boot\\src\\main\\java\\agenda\\saida.txt");
        BufferedWriter BArquivo = new BufferedWriter(Arquivo);
        int cont;

        for (cont = 30; cont <= 39; cont = cont + 1) {
            BArquivo.write(Recebe[cont - 30].nome);
            BArquivo.newLine();
            BArquivo.write(Recebe[cont - 30].tel + "");
            BArquivo.newLine();
            BArquivo.write(Recebe[cont - 30].sexo + "");
            BArquivo.newLine();
            BArquivo.write(Recebe[cont - 30].altura + "");
            BArquivo.newLine();
        }

        BArquivo.close();
        Arquivo.close();
        System.out.println("Dados gravados com sucesso!");
    }

    public static void MostrarDados(DadosAgenda Mostra[]) {
        int cont;
        String msg = "";

        for (cont = 0; cont <= 9; cont = cont + 1) {
            msg = msg + Mostra[cont].nome + " ";
            msg = msg + Mostra[cont].tel + " ";
            msg = msg + Mostra[cont].sexo + " ";
            msg = msg + Mostra[cont].altura + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);
    }

    public static DadosAgenda[] OrdenaDados(DadosAgenda Baguncado[]) {
        DadosAgenda Aux = new DadosAgenda(" ", 0, ' ', 0);
        int i, j;

        for (i = 0; i <= 8; i = i + 1) {
            for (j = i + 1; j <= 9; j = j + 1) {
                if ((Baguncado[i].nome).compareTo(Baguncado[j].nome) == 0) {
                    Aux = Baguncado[i];
                    Baguncado[i] = Baguncado[j];
                    Baguncado[j] = Aux;
                }
            }
        }

        System.out.println("Dados ordenados com sucesso!");
        return Baguncado;
    }

    public static void PesquisaDados(DadosAgenda Search[]) {
        DadosAgenda Aux = new DadosAgenda(" ", 0, ' ', 0.0);
        int cont = 0;
        String nome;
        boolean achou = false;

        nome = JOptionPane.showInputDialog("Digite um nome a pesquisar");

        while (!achou && cont < 10) {
            if (nome.compareTo(Search[cont].nome) == 0) {
                achou = true;
                Aux = Search[cont];
            } else {
                cont = cont + 1;
            }
        }

        if (achou) {
            JOptionPane.showMessageDialog(null, Aux.nome + " " + Aux.tel + " " + Aux.sexo + " " + Aux.altura);
        } else {
            JOptionPane.showMessageDialog(null, "não achou");
        }
    }

    public static void Menu() throws IOException {
   //1
        int cont, opcao;
        DadosAgenda Vet[] = new DadosAgenda[10];
        String msg = "";

        for (cont = 0; cont < 10; cont = cont + 1) {
            Vet[cont] = new DadosAgenda(" ", 0, ' ', 0.0);
        }

        msg = msg + "Digite 1 - Entrada de Dados\n";
        msg = msg + "Digite 2 - Pesquisa de Dados\n";
        msg = msg + "Digite 3 - Ordena Dados\n";
        msg = msg + "Digite 4 - Mostrar Dados\n";
        msg = msg + "Digite 5 - Gravar Dados\n";
        msg = msg + "Digite 0 - Sair do sistema.";
//}
        do {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(msg)); //2

            switch (opcao) { //2
                case 1:
                    Vet = EntradaDados();//[x1
                    break;
                case 2:
                    PesquisaDados(Vet);//[x2
                    break;
                case 3:
                    Vet = OrdenaDados(Vet);//[x3//
                    break;
                case 4:
                    MostrarDados(Vet);//[x4
                    break;
                case 5:
                    GravarDados(Vet);//[x5
                    break;
                case 0:
                    System.exit(0);//5

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");//4

            }
        } while (opcao != 0);

    }

    public static void main(String Mari[]) throws IOException {
        Menu();
    }
}
