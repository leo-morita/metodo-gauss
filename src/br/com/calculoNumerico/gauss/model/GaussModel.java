package br.com.calculoNumerico.gauss.model;

public class GaussModel {

    private String[][] matriz;

    public GaussModel(int ordemNaMatriz) {
        if (ordemNaMatriz < 2 || ordemNaMatriz > 10) {
            System.out.println("Erro! O valor está inválido. O valor permitido tem que estar entre 2 até 10");
            return;
        }

        matriz = new String[ordemNaMatriz][ordemNaMatriz];
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void imprimirMatriz() {
        for (int linha = 0; linha < matriz.length; linha++) {
            System.out.print("| ");
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (coluna == matriz[0].length-1) {
                    System.out.printf("%s |", matriz[linha][coluna]);
                } else {
                    System.out.printf("%s ", matriz[linha][coluna]);
                }
            }
            System.out.println();
        }
    }

}
