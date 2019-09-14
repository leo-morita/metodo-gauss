package br.com.calculoNumerico.gauss.model;

public class GaussModel {

    private int[][] matriz;

    public GaussModel(int ordemNaMatriz) {
        if (ordemNaMatriz > 10 || ordemNaMatriz < 2) {
            System.out.println("Erro! O valor está inválido. O valor permitido tem que estar entre 2 até 10");
            return;
        }

        matriz = new int[ordemNaMatriz][ordemNaMatriz];
    }

    public int[][] getMatriz() {
        return matriz;
    }

}
