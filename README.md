Todos nós já jogamos ou provávelmente conhecemos o jogo da forca. O jogo consiste em adivinhar uma palavra tentando acertar as letras nela contida.
As regras do jogo da forca são muito simples:

1 - Uma palavra deve ser adivinhada. Para isso a pessoa que pensou na palavra informa ao jogador quantas letras a palavra possuí.
2 - O jogador tenta adivinhar a palavra dizendo uma letra por vez (palpite).
- Caso o palpite do jogador esteja correto: A letra deve ser revelada na(s) posicão(ões) em que ela se encontra dentro da palavra.
- Caso o palpite do jogador esteja errado: A letra deve ser descartada e o jogador perde uma tentativa.
3 - Caso o jogador gaste todas suas tentativas, o jogo encerra-se e a palavra é mostrada completamente. 

O menu será composto de duas opções:
1 - Jogar.
2 - Gerar Relatórios.
0 - Sair

Requisitos para a Opção 1:

1 - Quando o jogo for iniciado, deve-se perguntar o nome do jogador e em qual modo ele gostaria de jogar.
Os modos disponíveis são: Fácil, Médio, Difícil.
O Modo Fácil dá ao jogador 7 tentativas
O Modo Médio dá ao jogador 5 tentativas
O Modo difícil dá ao jogador 3 tentativas
-> Um novo registro na base de dados,com o nome do jogador, o nível de dificuldade a data e a hora do início do jogo devem ser salvos na base de dados.

2 - Pedir para que um terceiro insira a palavra a ser adivinhada.
-> Essa palavra deve ser salva no banco de dados e associada ao jogo atual.

3 - A cada rodada uma letra deve ser informada. Caso a letra nao tenha sido informada anteriormente, é verificada sua existencia na palavra.
Se a letra existe na palavra, ela deve ser mostrada nas posicões em que ocupa. Senão o jogador perdeu uma tentativa.
Caso a letra tenha sido informada anteriormente, é pedido para que o jogador informe uma letra diferente até que uma letra diferete dos palpites já dados seja informada.
(Se o palpite for uma letra repetida, nao conta-se como uma tentativa perdida pois uma nova letra devera).

4 - A cada rodada o jogador pode digitar o número "0" para encerrar o jogo. Essa ação deve ser atualizada no registro da base de dados que corresponde a partida atual e identificar essa partida como ABANDONO.
-> A Data e a Hora de finalização do jogo devem ser salvas na base de dados.

5 - Se o jogador adivinhar a palavra, uma mensagem de parabéns deve ser exibida, e a quantidade de tentativas restantes. 
Se o jogador não adivinhar a palavra (esgotar a quantia de tentativas), uma mensagem de derrota deve ser exibida juntamente com a palavra correta e então o jogo deve ser encerrado.
-> Lembrem-se: Deve ser possível identificar na base de dados qual foi o resultado do jogo: VITORIA, DERROTA ou ABANDONO.
-> A Data e a Hora de finalização do jogo devem ser salvas na base de dados.

6 - A cada rodada as letras ja informadas devem ser mostradas para o jogador saber as letras que ja tentou (tanto as que acertou quanto as que errou) e quantas chances ainda possui.

Requisitos para a Opção 2:

O seguinte menu deve ser exibido:
1 - Gerar Relatório Geral
2 - Gerar Relatório de Vitórias
3 - Gerar Relatório de Derrotas

O arquivo RelatorioGeral.txt, RelatorioVitorias.txt e RelatorioDerrotas.txt deve ser gerado e cada registro dentro dele deve seguir o seguinte formato (deve haver uma linha de espaço entre cada registro do arquivo):

Nome: #Nome_Do_Jogador#
Dificuldade: #Dificuldade_Escolhida_pelo_Jogador#
Palavra: #Palavra_A_Ser_Adivinhada#
Resultado: #Vitoria_Derrota_Interrompido#
Data e Hora de Início: #Data_Hora_Inicio#
Data e Hora de Fim: #Data_Hora_Fim#

O formato acima serve para as três opções de relatórios.
O primeiro relatório considera todos os jogos.
O segundo relatório considera apenas jogos onde o jogador saiu vitorioso.
O terceiro relatório considera apenas jogos onde o jogador saiu derrotado.

-------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------- Bônus ----------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------
Criem um index.jsp onde eu possa escolher qual relatório desejo gerar e exibam os dados de cada um dos relatórios acima em uma tabela, em sua respectiva página, como por exemplo:

Nome Dificuldade Palavra Resultado Data e Hora de Início Data e Hora de Fim
Marcelo Fácil Banana Vitória 13/09/2018 06:00:00 13/08/2018 19:08:35

Cada uma das páginas de relatório devem possuír um link para voltar para a página inicial.
------------------------------------------------------------------------------------------------------------------------

OBS: A entrega será o link para o repositório do git com o código da prova.
