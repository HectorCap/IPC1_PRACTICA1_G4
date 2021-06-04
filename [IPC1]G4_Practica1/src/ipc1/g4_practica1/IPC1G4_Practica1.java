//03 Junio 2021
package ipc1.g4_practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class IPC1G4_Practica1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        //Menú de inicio de forma cíclica  
        // kevin 
        do {
            try {

                // intento de push
                System.out.println("-------------Menu principal-------------");
                System.out.println("    1.  Cargar matrices                 ");
                System.out.println("    2.  Sumar matrices                  ");
                System.out.println("    3.  Restar matrices                 ");
                System.out.println("    4.  Multiplicar matrices            ");
                System.out.println("    5.  Dividir matrices                ");
                System.out.println("    6.  Traspuesta de una matriz        ");
                System.out.println("    7.  Matriz inversa                  ");
                System.out.println("    8.  Potencia de una matriz          ");
                System.out.println("    9.  Determinante de una matriz      ");
                System.out.println("    10. Matriz R                        ");
                System.out.println("    11. Reportes                        ");
                System.out.println("    12. SALIR                           ");
                System.out.println("----------------------------------------");
                System.out.print("Ingrese una opción: ");
                opcion = entrada.nextInt();
                System.out.println();

                switch (opcion) {
                    case 1://1.  Cargar matrices   
                        break;
                    case 2://2.  Sumar matrices  
                        break;
                    case 3://3.  Restar matrices  
                        break;
                    case 4://4.  Multiplicar matrices  
                        break;
                    case 5://5.  Dividir matrices    
                        break;
                    case 6://6.  Traspuesta de una matriz  
                        break;
                    case 7://7.  Matriz inversa    
                        break;
                    case 8://8.  Potencia de una matriz   
                        break;
                    case 9://9.  Determinante de una matriz 
                        break;
                    case 10://10. Matriz R   
                        break;
                    case 11://11. Reportes 
                        break;
                    case 12://12. SALIR
                        break;
                    default:
                        System.out.println("Opcion no válida. Inténtelo de nuevo.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("¡Ups! Ocurrió un error, inténtalo de nuevo.");
                entrada.nextLine();
            }
        } while (opcion != 12);
    }

    public static void GuardarMatrizArchivo(String ruta, int[][] matriz) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            int contadorFilas = 0;
            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split(",");
                for (int i = 0; i < numeros.length; i++) {
                    matriz[contadorFilas][i] = Integer.parseInt(numeros[i]);
                }
                contadorFilas++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public static int[][] multiplicarMatriz(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        // se comprueba si las matrices se pueden multiplicar
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        // aquí se multiplica la matriz
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        /**
         * si no se cumple la condición se retorna una matriz vacía
         */
        return c;
    }
    public static int[][] sumarMatriz(int[][] matrizA, int[][] matrizB) {
        int[][] matrizResultado;
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;

        int filasB = matrizB.length;
        int columnasB = matrizB[0].length;

        System.out.println("Primera matriz:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print(matrizA[i][j] + "   ");
            }
            System.out.println("");
        }

        System.out.println("Segunda matriz:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print(matrizB[i][j] + "   ");
            }
            System.out.println("");
        }

        if (filasA == filasB && columnasB == columnasA) {

            matrizResultado = new int[filasA][columnasA];
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
                }
            }

        } else {
            throw new Error("Las matrices deben tener la misma cantidad de filas que columnas");
        }
        System.out.println("Matriz resultado:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print(matrizResultado[i][j] + "   ");
            }
            System.out.println("");
        }
        return matrizResultado;
    }
    public static int[][] restarMatriz(int[][] matrizA, int[][] matrizB) {
        int[][] matrizResultado;
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;

        int filasB = matrizB.length;
        int columnasB = matrizB[0].length;

        if (filasA == filasB && columnasB == columnasA) {

            matrizResultado = new int[filasA][columnasA];
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    matrizResultado[i][j] = matrizA[i][j] - matrizB[i][j];
                }
            }

        } else {
            throw new Error("Las matrices deben tener la misma cantidad de filas que columnas");
        }
        System.out.println("Matriz resultado:");

        return matrizResultado;
    }
    
    
}
