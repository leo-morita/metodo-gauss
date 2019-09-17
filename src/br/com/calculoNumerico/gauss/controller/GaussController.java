package br.com.calculoNumerico.gauss.controller;

import java.util.Scanner;

public class GaussController {

    public void adicionarValores(String[][] matriz) {
        Scanner teclado = new Scanner(System.in);

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.format("matriz[%d][%d] = ", linha, coluna);
                String valor = teclado.nextLine();

                matriz[linha][coluna] = valor + "x" + coluna;
            }
        }
    }

    public void escalonar(String[][] matriz) {
        System.out.println("Etapa K=0");

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna].split("x")[0] + " ");
            }
            System.out.println();
        }
    }

}
