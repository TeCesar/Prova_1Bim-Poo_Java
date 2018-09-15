package br.edu.fapi.menus;

import br.edu.fapi.model.Jogador;

import java.util.Scanner;

public class MenuPrincipal {

    public MenuPrincipal() {
        Jogador jogador = new Jogador();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        System.out.println("Ola!! Bem vindo ao jogo da forca!!");
        System.out.println("Brought to you by DKRT Team");
        System.out.println();
        System.out.println();
        System.out.println("Por favor, digite seu nome.");
        jogador.setNome(scanner.nextLine());

        while (continua) {
            System.out.println();
            System.out.println("Escolha uma opcao");
            System.out.println("1- Jogar");
            System.out.println("2- Gerar Relatorios");
            System.out.println("0- sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    MenuJogo.menuJogo(scanner, jogador);
                    break;
                case 2:
                    MenuRelatorios.menuRelatorios(scanner, jogador);
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Opcao invalida. Por favor digite novamente");
            }
        }

    }

}
