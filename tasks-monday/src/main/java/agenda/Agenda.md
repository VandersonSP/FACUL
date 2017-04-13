# Agenda

## tecnica funcional

### Particionamento em Classes de Equivalencia
 Verificar se o codigo executa as funções :
  Entrada de Dados.
  Pesquisa de Dados.
  Ordena Dados.
  Mostrar Dados.
  Gravar Dados.
  Sair do sistema.
 Passando um parametro no teste e verificar o resultado.

### Analise de valor limite
 Validar se aparece a mensagem "Opção inválida" se o valor no parametro for:
 vazio.
 numerico 6 a 50.
 numerico -1 a -50.
 string aA-zZ.
 caractes de randon StringNumber;

### Grafo de Causa  e Efeito
 Validar os valores validos e invalidos em questão.
 Condições a serem verificadas :
                
Se ao digitar 1 no parametro executa o metodo EntradaDados.
Se ao digitar 2 no parametro executa o metodo PesquisaDados.
Se ao digitar 3 no parametro executa o metodo OrdenaDados.
Se ao digitar 4 no parametro executa o metodo MostrarDados.
Se ao digitar 5 no parametro executa o metodo GravarDados.
Se ao digitar 0 no parametro executa fechar tudo.


### Teste Estruturado ou teste de caixa branca

1-Critério Baseado em fluxo de controle

- Se ao digitar 1 no parametro executa o metodo X:

                        
                           
              (5)<-----[3-X]----
					     |     |
					     |    /
					     |  /		     
				(1) --> (2) ----->(5)
				         | \
                         |   \          
                         |    |
              (5)<----- [4]---
              
             [4]:                       
             
              (4.2)<---[4]-->(4.1)   
               |     //\\   |
               |     | |    |
                -----/  \---     
                     
             [x.1]:

             (8)----->[x.1]<---(7)------------------\
              |         |                            |
              |         |             ------------->(5)-----
              |         \/            |             /\     |
              ---------(1)--->(2)--->(3)-----        \     |
                                     /\     |         ----(6)
                                      \     |       
                                       ----(4)     
                                                   
             [x.2]:
             
             [x.3]:
             [x.4]:
             [x.5]:

2-Critério Baseado no fluxo de dados

- FLUXO DE VALOR 55 INVALIDO E CLIK OK:
(1): int cont, opcao; ... INICIALIZACAO... 

(2): opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));   switch (opcao) {
    VALUE = 55
    
(4): JOptionPane.showMessageDialog(null, "Opção inválida");

(4.1): BOTÃO OK
 
(4): } } while (opcao != 0);

(4): => (2)


              (5)<-----[3-X]----
					     |     |
					     |    /
					     |  /		     
				(1) --> (2) ----->(5)
				         | \
                         |   \          
                         |    |
              (5)<----- [4]---
              
             [4]:                       
             
              (4.2)<---[4]-->(4.1)   
               |     //\\   |
               |     | |    |
                -----/  \---     

3-Criério Baseado na complexidade

- Função findAmountJpg tem a complexidade O(n) pois tem no minimo 3 atribuições e no maximo 9, 1 comparação , 2 calculos, 1 loop, e 2 função removeJpg e toString.


    







