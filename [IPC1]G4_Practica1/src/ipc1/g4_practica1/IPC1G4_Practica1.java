//03 Junio 2021
package ipc1.g4_practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class IPC1G4_Practica1 {

    //public static int Matriz[][][];//Esta hace referencia al guardado de cada una de las matrices
    public static Scanner entrada = new Scanner(System.in);

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
                        Ruta();
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

    public static void getContentOfFile(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            //Cada linea leída del txt representa una matriz            
            while ((linea = br.readLine()) != null) {

                String[] nombre_datos = linea.split(":");
                //nombre_datos[0] es el nombre de la matriz
                System.out.println(nombre_datos[1].trim());// estan los datos de la matriz

                if (nombre_datos[1].contains(";")) {
                    //La matriz posee varias filas, se puede hacer split
                    if (nombre_datos[1].contains(",")) {
                        //La matriz posee varias columnas

                        String[] filas = nombre_datos[1].split(";");
                        //Cada elemento del array es una fila de la matriz

                        String[] columnas = filas[0].split(",");
                        //Este split es solo para obtener el número de columnas de la matriz y poder declararla

                        //Declarando la matriz
                        double[][] Matriz = new double[filas.length][columnas.length];

                        for (int i = 0; i < filas.length; i++) {
                            String[] datosEnLaFila = filas[i].split(",");
                            //Para cada fila, se hace split de las comas para obtener los datos de la matriz

                            for (int j = 0; j < datosEnLaFila.length; j++) {
                                Matriz[i][j] = Double.parseDouble(datosEnLaFila[j].trim());
                                System.out.print("" + Matriz[i][j] + "\t");
                            }
                            System.out.println("\t");
                        }

                    } else {
                        //La matriz posee una columna y varias filas

                        String[] filas = nombre_datos[1].split(";");
                        //Cada elemento del array es una fila de la matriz

                        //Declarando la matriz
                        double[][] Matriz = new double[filas.length][1];

                        for (int i = 0; i < filas.length; i++) {
                            Matriz[i][0] = Double.parseDouble(filas[i].trim());
                        }

                    }
                } else if (nombre_datos[1].contains(",")) {
                    //La matriz posee una fila y varias columnas

                    String[] columnas = nombre_datos[1].split(",");
                    //Cada elemento del array es una columna de la matriz

                    //Declarando la matriz
                    double[][] Matriz = new double[1][columnas.length];

                    for (int i = 0; i < columnas.length; i++) {
                        Matriz[0][i] = Double.parseDouble(columnas[i].trim());
                    }

                } else {
                    //La matriz posee un único dato

                    //Declarando la matriz
                    double[] Matriz = new double[1];
                    Matriz[0] = Double.parseDouble(nombre_datos[1].trim());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void Ruta() {//carga y guardado del contenido del Txt
        System.out.print("Ingrese ruta del txt: ");
        String ruta = entrada.nextLine();
        getContentOfFile(ruta);
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
