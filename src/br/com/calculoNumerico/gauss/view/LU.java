package br.com.calculoNumerico.gauss.view;

import br.com.calculoNumerico.gauss.model.Pivo;

public class LU {
    public void getLU(int n, double[][] m){
        double[][]L = new double[n][n]; 
        double[][]U = new double[n][n]; 
        double[][]LU = new double[n][n]; 
    for (int i = 0; i < n; i++) { 
        // Decomposição U
        for (int k = i; k < n; k++) { 
            double soma = 0; 
            for (int j = 0; j < i; j++) 
                soma += (L[i][j] * U[j][k]); 
            // Evaluating U(i, k) 
            U[i][k] = m[i][k] - soma; 
        } 
        // Decomposição L
        for (int k = i; k < n; k++)  { 
            if (i == k) 
                L[i][i] = 1;
            else{
                double soma = 0; 
                for (int j = 0; j < i; j++) 
                    soma += (L[k][j] * U[j][i]); 
                L[k][i] = (m[k][i] - soma) / U[i][i]; 
            } 
        }        
    } 
        
        System.out.println("L");
        for(int i = 0; i < n;i++){
            for(int j =0; j < n;j++){
                System.out.print(L[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("U");
        for(int i = 0; i < n;i++){
            for(int j =0; j < n;j++){
                System.out.print(U[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        //Multiplicação de matriz
        System.out.println("L*U");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < n; x++) {
                    LU[i][j] += L[i][x] * U[x][j];
                }
            }
        }
        for(int i = 0; i < n;i++){
            for(int j =0; j < n;j++){
                System.out.print(LU[i][j]+" ");
            }
            System.out.println("");
        }
    }
}


