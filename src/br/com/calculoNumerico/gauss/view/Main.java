package br.com.calculoNumerico.gauss.view;

public class Main {
    private static final double nuloNum = 1e-5;

    public Main(int tamanhoM, double[][] m, double[] ig){
        int TamanhoMatriz = tamanhoM;
        double[][] A = m;

        double[] igual = ig;

        double[] x = LinearS(A, igual);
        int num = 1;

        for (int i = 0; i < TamanhoMatriz; i++) {
            System.out.printf("x" + num + " = ");
            System.out.printf("%.4f ", x[i]);
            System.out.printf("\n");
            num++;
        }
    }

    public static void main(String[] args) {
        int TamanhoMatriz = 4;
        double[][] A = {
                {1, 2, 3, 4},
                {2, 1, 2, 3},
                {3, 2, 1, 2},
                {4, 3, 2, 1}
        };

        double[] igual = {10, 7, 6, 5};

        double[] x = LinearS(A, igual);
        int num = 1;

        /*for (int i = 0; i < TamanhoMatriz; i++) {
            System.out.printf("x" + num + " = ");
            System.out.printf("%.4f ", x[i]);
            System.out.printf("\n");
            num++;
        }*/
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

            // Teste
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();

            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];

                // Teste
                System.out.println("Teste: Valor = " + alpha);

                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
            imprimirMatriz(A, b);
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

    private static void imprimirMatriz(double[][] A, double[] b) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j == A[i].length-1) {
                    System.out.printf("%-12f", A[i][j]);
                    System.out.printf("|%-12f%n", b[i]);
                } else {
                    System.out.printf("%-12f", A[i][j]);
                }
            }
        }
    }

}