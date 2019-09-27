package br.com.calculoNumerico.gauss.view;

import java.text.DecimalFormat;

public class Main2 {
    public static void main(String[] args) {
        double[][] a = {{1, 2, 3, 4, 10},
                {2, 1, 2, 3, 7},
                {3, 2, 1, 2, 6},
                {4, 3, 2, 1, 5}
        };
        metodoEliminacaoGauss(a);
        /*System.out.printf("%-12s%-12s%s\n","Coluna 1","Coluna 2","Coluna 3");
        System.out.printf("%-12f%-12f%f\n",15.5556,12.5556,5.345666);*/
    }

    public static double[][] metodoEliminacaoGauss(double[][] a) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###,000000");
        double pivo;
        double multiplicador;
        double[][] b;

        for(int etapa = 0; etapa < a.length-1; etapa++) {
            System.out.println("K = " + etapa);
            b = a;
            for(int i = 1 + etapa; i < a.length; i++) {
                pivo = a[etapa][etapa];
                System.out.print("pivo: ("+pivo+")   ");
                multiplicador = b[i][etapa] / pivo;
                System.out.print("m: ("+multiplicador+")   ");
                for(int j = etapa; j < a[i].length; j++) {
                    //System.out.print("b:("+b[i][etapa] + ")   ");
                    if(a[i][j] != 0) {
//                        a[i][j] = Double.parseDouble(decimalFormat.format(b[i][j] - multiplicador * a[etapa][j]));
                        a[i][j] = b[i][j] - multiplicador * a[etapa][j];
                    }
//                    System.out.print(a[i][j] + "\t");
                }
                System.out.println();
                imprimir(a);
            }
            System.out.println("---------------------------");
        }

        System.out.println("Resultado");
        imprimir(a);
        return null;
    }

    public static void imprimir(double[][] a) {
        int indice = 0;
        for (int i = 0; i < a.length; i++) {
            indice = i + 1;
            if (i == a.length-1) {
                System.out.printf("%-12s", "x" + indice);
                System.out.printf("|%-12s%n", "b");
                /*System.out.println("Teste: " + "x" + i);
                System.out.println("Teste: " + "| b");*/
            } else {
                System.out.printf("%-12s", "x" + indice);
//                System.out.println("Teste: " + "x" + i);
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j == a[i].length-1) {
//                    System.out.printf("%-12d%-12d%d\n",15,12,5);
                    System.out.printf("|%-12f%n", a[i][j]);
//                    System.out.print(a[i][j] + "|\t");
                } else {
                    System.out.printf("%-12f", a[i][j]);
//                    System.out.print(a[i][j] + "\t\t");
                }
            }
            //System.out.println();
        }

        /*double[] aux = new double[11];
        double b = 0.0;
        double[] resultante = new double[11];

        for (int i = a.length-1; i >= 1; i--) {
            System.out.println("Iteração: " + i);
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > 0.0) {
                    if (j == a[i].length-1) {
                        b = a[i][j];
                    } else {
                        aux[j] = a[i][j];
                    }
                }
                System.out.println(a[i][j]);
            }
            for (int j = 0; j < aux.length; j++) {
                if (aux[j] > 0.0) {

                }
            }*/
//        }

    }
}
