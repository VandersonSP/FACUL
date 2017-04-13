### scheduler-spring-boot

##tecnica funcional

#Particionamento em Classes de  Equivalencia
 Verificar se o metodo #findAmountJpg esta funcionando,
 passar uma um parametro uma pagina com 5 imagens .jpg e verificar se o resultado é 5;

#Analise de valor limite
 Validar se a condição esta validando os limites,
 Condição a ser verificada : # if(amountjpg > 0){
 Se a quantidade de imagens for zero o resultado a ser enviado no email é "" Nenhuma imagem .jpg foi encontrada na pagina!""
e se a quantidade de imagens for zero o resultado do metodo é zero


#Grafo de Causa  e Efeito
 Validar os valores validos e invalidos em questão.
 Condições a serem verificadas :
                 if(amountjpg > 10){
                     result = result+ "Pagina Pesada";
                 }else if(amountjpg > 5 && amountjpg<10){
                     result = result+ "Pagina um Pouco carregada";
                 }else if(amountjpg > 2 && amountjpg<5){
                     result = result+ "Pagina Comum";
                 }else{
                     result = result+ "Pagina Basica";
                 }
 Se a quantidade de imagens na pagina for maior que 10  adicionar ao resultado "Pagina Pesada"
 Se a quantidade de imagens na pagina for maior que 5 e menor que 10 adicionar ao resultado "Pagina um Pouco Carregada"
 Se a quantidade de imagens na pagina for maior que 2 e menor que 5 adicionar ao resultado "Pagina Comun"
 Se a quantidade de imagens na pagina for menor que 2 e maior que 0 adicionar ao resultado "Pagina Basica"





###Teste Estruturado ou teste de caixa branca

1-Critério Baseado em fluxo de controle

-findAmountJpg:

								   --------------            ---------------
								  /              \          /               \
								 \/			      \        /                \/
				(1) --> (2) --> (3)-------------->(4)    (5) ----->(6) ---->(7)
				         	     \                       /\
				          	      \                      /
							       ----------------------				           
							 

2-Critério Baseado no fluxo de dados

-findAmountJpg:
(1): txt = " imagem.jpg"

(2):  int result = 0;
        String auxtxt = "";
        String txtOrig = txt;

(3): while (auxtxt.length() != txt.length()) {
           
(4):  auxtxt= txt.toString();
      txt = removeJpg(txt);

(3): while (auxtxt.length() != txt.length()) {
           
(4):  auxtxt= txt.toString();
      txt = removeJpg(txt);
      
(3): while (auxtxt.length() != txt.length()) {

(5): if (txtOrig.length() != txt.length()) {

(6): int var = txtOrig.length() - txt.length();
     result = var / 2;

(7): return result;

								   --------------            ---------------
								  /              \          /               \
								 \/			      \        /                \/
				(1) --> (2) --> (3)-------------->(4)    (5) ----->(6) ---->(7)
				         	     \                       /\
				          	      \                      /
							       ----------------------				

3-Criério Baseado na complexidade 

- Função findAmountJpg tem a complexidade O(n) pois tem no minimo 3 atribuições e no maximo 9, 1 comparação , 2 calculos, 1 loop, e 2 função removeJpg e toString.
