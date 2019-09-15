package br.com.calculoNumerico.gauss.view;

import br.com.calculoNumerico.gauss.controller.GaussController;
import br.com.calculoNumerico.gauss.model.GaussModel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o valor do n: ");
        int n = teclado.nextInt();
        teclado.nextLine();

        GaussModel gaussModel = new GaussModel(n);
        GaussController gaussController = new GaussController();

        gaussController.adicionarValores(gaussModel.getMatriz());
        gaussModel.imprimirMatriz();
    }

}
