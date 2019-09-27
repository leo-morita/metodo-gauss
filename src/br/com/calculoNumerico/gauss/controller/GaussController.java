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
        // Fase da eliminação
        System.out.println("Etapa K=0");

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna].split("x")[0] + " ");
            }
            System.out.println();
        }

        // Determinar o pivô
        int[][] auxiliar = new int[matriz.length][matriz[0].length];
        int indicePivo = 0;

        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            for (int linha = 0; linha < matriz.length; linha++) {
                if (linha == 0) {
                    System.out.println(matriz[coluna][linha]);
                }
            }
        }

        /*for (int linha = 0; linha < matriz.length; linha++) {
            String pivo = "";
            int pivoAtual = 0;
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (indicePivo < matriz.length-1) {
                    pivo = matriz[linha][indicePivo];
                    pivoAtual = Integer.parseInt(pivo.split("x")[0]);
                }

                *//*int elementoAtual = Integer.parseInt(matriz[linha+indicePivo][coluna].split("x")[0]);
                int valorAtual = (((elementoAtual / pivoAtual) * pivoAtual) - elementoAtual);
                System.out.print("[Pivô: " + pivoAtual + " ");
                System.out.print("Elemento Atual: " + elementoAtual + " ");
                System.out.println("Novo Valor: " + valorAtual + "]");
                auxiliar[linha][coluna] = valorAtual;*//*
            }
            if (indicePivo < matriz.length-1) {
                System.out.println(pivoAtual);
            }
            indicePivo += 1;
        }*/

        /*for (int linha = 0; linha < auxiliar.length; linha++) {
            for (int coluna = 0; coluna < auxiliar[0].length; coluna++) {
                int elementoAtual = auxiliar[linha][coluna];
                System.out.println(elementoAtual);
            }
        }*/
    }

}
