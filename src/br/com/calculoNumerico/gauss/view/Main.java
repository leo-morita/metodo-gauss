package br.com.calculoNumerico.gauss.view;

public class Main {

    private static final double nuloNum = 1e-5;

    public static void main(String[] args) {
        int TamanhoMatriz = 4;
        double[][] A = {
                { 1, 2, 3, 4},
                { 2, 1, 2, 3},
                { 3, 2, 1, 2},
                { 4, 3, 2, 1}
        };

        double[] igual = { 10, 7, 6, 5 };

        double[] x = LinearS(A, igual);
        int num = 1;

        for (int i = 0; i < TamanhoMatriz; i++) {
            System.out.printf("x" + num + " = ");
            System.out.printf("%.4f ", x[i]);
            System.out.printf("\n");
            num++;
        }
    }

    public static double[] LinearS(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {
            System.out.println("K = " + p);

            // Encontra a coluna Pivô e substitui
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            if (Math.abs(A[p][p]) <= nuloNum) {
                throw new ArithmeticException("Determinante é 0");
            }

            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
            int indice;
            for (int i = 0; i < A.length; i++) {
                indice = i + 1;
                if (i == A.length-1) {
                    System.out.printf("%-12s", "x" + indice);
                    System.out.printf("|%-12s%n", "b");
                /*System.out.println("Teste: " + "x" + i);
                System.out.println("Teste: " + "| b");*/
                } else {
                    System.out.printf("%-12s", "x" + indice);
//                System.out.println("Teste: " + "x" + i);
                }
            }

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    if (j == A[i].length-1) {
//                    System.out.printf("%-12d%-12d%d\n",15,12,5);
                        System.out.printf("%-12f", A[i][j]);
                        System.out.printf("|%-12f%n", b[i]);
//                    System.out.print(a[i][j] + "|\t");
                    } else {
                        System.out.printf("%-12f", A[i][j]);
//                    System.out.print(a[i][j] + "\t\t");
                    }
                }
            }
            System.out.println();
        }

        // Substituição de volta
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }

}