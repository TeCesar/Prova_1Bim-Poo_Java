package br.edu.fapi.operacoes;

import br.edu.fapi.model.Jogador;

import java.util.List;
import java.util.Scanner;

public class Operacoes {

    public static void limpaTela() {
        for (int cont = 0; cont < 50; cont++) {
            System.out.println("");
        }
    }

    public static boolean temHifen (String palavra){
        if (palavra.contains("-")){
            return true;
        }
        return false;
    }

    public static String lerPalavra(Scanner scanner, Jogador jogador) {
        boolean palavraValida;
        String palavra;

        /*não foi possível validar caso o usuário de enter sem digitar nada*/
        do {
            palavraValida = true;
            boolean repete = true;
            System.out.println(jogador.getNome() + ", digite a palavra escolhida ('-' é aceito)");
            scanner.nextLine();
            palavra = scanner.nextLine();
            palavra = palavra.toUpperCase();
            palavra = ignoraAcento(palavra);

            if (palavra.contains("-")) {
                palavra = palavra.replaceAll("-", "á");
            }

            for (int cont = 0; cont < palavra.length(); cont++) {
                char c = palavra.charAt(cont);

                if (!Character.isLetter(c)) {

                    while (repete) {
                        System.out.println("");
                        System.out.println("A palavra não pode conter números, caracteres especiais exceto '-',\nestar vazia ou com espaço.");
                        palavraValida = false;
                        System.out.println("");
                        repete = false;
                    }
                }
            }


        } while (!palavraValida);
        palavra = palavra.replaceAll("á", "-");
        System.out.println(palavra);

        return palavra;
    }

    public static String ignoraAcento(String palavra) {

        palavra = palavra.replaceAll("[èéêë]", "e");
        palavra = palavra.replaceAll("[ûù]", "u");
        palavra = palavra.replaceAll("[ïî]", "i");
        palavra = palavra.replaceAll("[àâ]", "a");
        palavra = palavra.replaceAll("ô", "o");

        palavra = palavra.replaceAll("[ÈÉÊË]", "E");
        palavra = palavra.replaceAll("[ÛÙ]", "U");
        palavra = palavra.replaceAll("[ÏÎ]", "I");
        palavra = palavra.replaceAll("[ÀÂ]", "A");
        palavra = palavra.replaceAll("Ô", "O");

        return palavra;

    }

    public static void mostrarPalavraAdvinha(String palavra, String[] palavraAdvinha) {
        for (int cont = 0; cont < palavra.length(); cont++) {
            System.out.print(palavraAdvinha[cont] + " ");
        }
    }

    public static String[] criaPalavraAdvinha(String palavra) {
        String[] palavraAdvinha = new String[palavra.length()];

        for (int cont = 0; cont < palavra.length(); cont++) {
            palavraAdvinha[cont] = "_";
        }

        if (palavra.contains("-")){
            int hifen = palavra.indexOf('-');
            palavraAdvinha[hifen] = "-";
        }

        return palavraAdvinha;
    }

    public static String validaLetraAdvinha(Scanner scanner) {
        boolean leitorLetra;
        String letra;

        do {
            leitorLetra = false;
            char c;

            do {
                System.out.print("Escolha uma letra (ou '0' para abandonar o jogo): ");
                letra = scanner.nextLine();
                letra = letra.toUpperCase();
                c = letra.charAt(0);
                if (!Character.isLetter(c) && !"0".equalsIgnoreCase(String.valueOf(c))) {
                    System.out.println("");
                    System.out.println("Caracter inválido, são aceitas apenas letras. Digite novamente");
                }
            } while (!Character.isLetter(c) && !"0".equalsIgnoreCase(String.valueOf(c)));

            if (letra.length() != 1 || letra.isEmpty()) {
                System.out.println("");
                System.out.println("");
                System.out.println("Letra inválida, apenas é válido 1(um) caractere. Digite novamente");
            } else {
                leitorLetra = true;
            }
        } while (!leitorLetra);

        return letra;
    }

    public static boolean confereLetrasFaladas(List<String> letrasEscolhidas, String letra) {
        int contLista = letrasEscolhidas.size();
        for (int cont = 0; cont < contLista; cont++) {
            if (letra.equals(letrasEscolhidas.get(cont))) {
                return true;
            }
        }

        return false;
    }

    public static void mostrarLetrasEscolhidas(List<String> letrasEscolhidas) {
        int contLista = letrasEscolhidas.size();

        for (int cont = 0; cont < contLista; cont++) {
            System.out.print(letrasEscolhidas.get(cont) + " ");
        }
    }
}
