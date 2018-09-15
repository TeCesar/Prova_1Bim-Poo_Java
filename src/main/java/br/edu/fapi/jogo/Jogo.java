package br.edu.fapi.jogo;

import br.edu.fapi.model.Jogador;
import br.edu.fapi.operacoes.Operacoes;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

    public Jogo(Scanner scanner, Jogador jogador) {
        String palavra;
        int numLetraAtual;
        ArrayList<String> letrasEscolhidas = new ArrayList();
        boolean letraJaFalada;
        int contDiminuiVida;
        String letra;
        boolean acabaJogo = false;

        //leitura da palavra e criação da palavra que contem  "_" no lugar das letras.
        palavra = Operacoes.lerPalavra(scanner, jogador);

        boolean temHifen;
        temHifen = Operacoes.temHifen(palavra);

        if (temHifen){
            numLetraAtual = 1;
        } else {
            numLetraAtual = 0;
        }

        Operacoes.limpaTela();
        String[] palavraAdvinha = Operacoes.criaPalavraAdvinha(palavra);

        System.out.println("");

        System.out.println("Quantidade de letras da palavra: " + palavra.length());
        Operacoes.mostrarPalavraAdvinha(palavra, palavraAdvinha);
        System.out.println("");
        System.out.println("");
        System.out.println("Vidas restantes: " + jogador.getNumVidas());

        do {
            System.out.println("");
            System.out.println("");
            contDiminuiVida = 0;
            letraJaFalada = false;

            letra = Operacoes.validaLetraAdvinha(scanner);

            if (letra.equalsIgnoreCase("0")){
                System.out.println("Jogo encerrado");
                jogador.setSituacao("ABANDONO");
                break;
            }

            //confere se já possui a letra digitada no ArrayList de letrasEscolhidas.
            letraJaFalada = Operacoes.confereLetrasFaladas(letrasEscolhidas, letra);

            /*se já houver uma letra igual no ArrayList, o programa avisa que a letra está repetida e segue sem
                  salvar ou comparar nada.*/
            if (letraJaFalada) {
                Operacoes.limpaTela();
                System.out.println("A letra '" + letra + "' já foi escolhida. Digite outra letra");
                System.out.print("Letras já escolhidas: ");
                Operacoes.mostrarLetrasEscolhidas(letrasEscolhidas);
                System.out.println("");
            } else {
                Operacoes.limpaTela();

                letrasEscolhidas.add(letra);

                System.out.print("Letras já escolhidas: ");
                Operacoes.mostrarLetrasEscolhidas(letrasEscolhidas);

                System.out.println("");
                System.out.println("");

                //não foi possível transformar esse "for" em método.
                //este for faz as trocas dos "_" pela letra acertada da palavra em suas respectivas posições.
                for (int cont = 0; cont < palavra.length(); cont++) {
                    if (palavra.charAt(cont) == letra.charAt(0)) {
                        palavraAdvinha[cont] = letra;
                        numLetraAtual = numLetraAtual + 1;
                    } else {
                        contDiminuiVida = contDiminuiVida + 1;
                    }
                }

            }

            //este if valida se o jogador deve perder uma vida caso a palavra não contenha a letra escolhida.
            //também contém a escolha de jogar de novo ou não.
            if (contDiminuiVida == palavra.length()) {
                jogador.setNumVidas(jogador.getNumVidas()-1);
                System.out.println("A letra '" + letra + "' não corresponde a nenhuma letra da palavra. (-1 vida)");
                System.out.println("");
                Operacoes.mostrarPalavraAdvinha(palavra, palavraAdvinha);
                System.out.println("");

                if (jogador.getNumVidas() == 0) {
                    Operacoes.limpaTela();
                    System.out.println("Suas vidas acabaram " + jogador.getNome() + " :( ... Infelizmente você perdeu.");
                    System.out.println("A palavra era: " + palavra);
                    jogador.setSituacao("DERROTA");
                    acabaJogo = true;
                }
            } else {
                Operacoes.mostrarPalavraAdvinha(palavra, palavraAdvinha);
                System.out.println("");
            }

            //mostra o número de vidas restante até a mesma chegar em 0.
            if (jogador.getNumVidas() != 0) {
                System.out.println("");
                System.out.println("Vidas restantes: " + jogador.getNumVidas());
            }

            //este if valida se o jogador acertou a palavra antes que suas vidas acabassem ou não.
            //também contém a escolha de jogar de novo ou não.
            if (numLetraAtual == palavra.length()) {
                Operacoes.limpaTela();
                System.out.println("Parabens " + jogador.getNome() + "!!!");
                System.out.println("Você ganhou acertando a palavra: " + palavra);
                System.out.println("Suas vidas restantes: " + jogador.getNumVidas());
                jogador.setSituacao("VITORIA");
            }
            //do/while que possibilita os turnos do jogo.
        } while (!acabaJogo && numLetraAtual != palavra.length());

    }
}
