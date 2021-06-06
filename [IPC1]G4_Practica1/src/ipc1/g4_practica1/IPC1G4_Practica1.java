//05 Junio 2021
package ipc1.g4_practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class IPC1G4_Practica1 {

    //public static int Matriz[][][];//Esta hace referencia al guardado de cada una de las matrices
    public static Scanner entrada = new Scanner(System.in);
    public static double matrizA[][];
    public static double matrizB[][];
    public static double matrizC[][];
    public static double matrizD[][];
    public static double matrizE[][];
    public static double matrizF[][];
    public static double matrizG[][];
    public static double matrizH[][];
    public static double matrizI[][];
    public static double matrizJ[][];
    public static double matrizK[][];
    public static double matrizL[][];
    public static double matrizM[][];
    public static double matrizN[][];
    public static double matrizO[][];
    public static double matrizP[][];
    public static double matrizQ[][];
    public static double matrizR[][];
    public static double matrizS[][];
    public static double matrizT[][];
    public static double matrizU[][];
    public static double matrizV[][];
    public static double matrizW[][];
    public static double matrizX[][];
    public static double matrizY[][];
    public static double matrizZ[][];
    public static String[] nombre_datos;//Vector donde estan los nombres de la matriz

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
                        
                            System.out.println("Ingrese el nombre de la primera Matriz:");
                            double[][] matriz1 = EncontrarMatriz();//encuentra la matriz para poder ser utilizada y la guardamos en nueva variable
                            System.out.println("Ingrese el nombre de la segunda Matriz:");
                            double[][] matriz2 = EncontrarMatriz();
                            if (matriz1.length==matriz2.length) {
                            
                        
                            matrizR = sumarMatriz(matriz1, matriz2);
                            }
                            else{
                                System.out.println("la matriz no es de mismo orden, no se pueden sumar");
                            }
                       break;
                    case 3://3.  Restar matrices 
                        
                        System.out.println("Ingrese el nombre de la primera Matriz:");
                        double[][] matriz3 = EncontrarMatriz();//encuentra la matriz para poder ser utilizada y la guardamos en nueva variable
                        System.out.println("Ingrese el nombre de la segunda Matriz:");
                        double[][] matriz4 = EncontrarMatriz();
                        
                        if (matriz3.length==matriz4.length) {
                        matrizR = restarMatriz(matriz3, matriz4);
                        }
                            else{
                                System.out.println("la matriz no es de mismo orden, no se pueden restar");
                            }
                        
                        break;
                        
                    case 4://4.  Multiplicar matrices  
                        submenuMultiplicacion(); //ACCEDIENTO AL METODO
                        break;
                    case 5://5.  Dividir matrices    
                        break;
                    case 6://6.  Traspuesta de una matriz  
                        double[][] matriz7 = EncontrarMatriz();
                        matrizR = TranspuestaMatriz(matriz7);
                        break;
                    case 7://7.  Matriz inversa    
                        break;
                    case 8://8.  Potencia de una matriz   
                        break;
                    case 9://9.  Determinante de una matriz 
                        break;
                    case 10://10. Matriz R   
                        System.out.println("La matriz R es: ");
                        for (int i = 0; i < matrizR.length; i++) {
                            for (int j = 0; j < matrizR[0].length; j++) {

                                System.out.print(matrizR[i][j] + "   ");
                            }
                            System.out.println("");
                        }
                        break;
                    case 11://11. Reportes 
                        break;
                    case 12://12. SALIR
                        System.out.println("Gracias por utilizar el programa ");
                        System.out.println("Saliendo...");
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
        int contMatriz = 0;
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

                nombre_datos = linea.split(":");
                //nombre_datos[0] es el nombre de la matriz
//                System.out.println(nombre_datos[1].trim());// estan los datos de la matriz
                System.out.println(nombre_datos[0].trim());//estan los datos de los indices

                if (nombre_datos[1].contains(";") || nombre_datos[1].contains(",")) {
                    //La matriz posee varias filas, se puede hacer split
                    if (nombre_datos[1].contains(",") || nombre_datos[1].contains(";")) {
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
                                System.out.print("|" + Matriz[i][j] + "|" + "\t");

                            }

                            System.out.println("\t");
                            String letra = String.valueOf(nombre_datos[0]);//PARSEA EL INDICE PARA ENTRAR AL SWITCH Y LLENAR LA MATRIZ CORRESPONDIENTE

                            switch (letra) {
                                case "A":
                                    matrizA = Matriz;

                                    break;

                                case "B":
                                    matrizB = Matriz;

                                    break;
                                case "C":
                                    matrizC = Matriz;

                                    break;

                                case "D":
                                    matrizD = Matriz;

                                    break;
                                case "E":
                                    matrizE = Matriz;

                                    break;
                                case "F":
                                    matrizF = Matriz;

                                    break;
                                case "G":
                                    matrizG = Matriz;

                                    break;
                                case "H":
                                    matrizH = Matriz;

                                    break;
                                case "I":
                                    matrizI = Matriz;

                                    break;
                                case "J":
                                    matrizJ = Matriz;

                                    break;
                                case "K":
                                    matrizK = Matriz;

                                    break;
                                case "L":
                                    matrizL = Matriz;

                                    break;
                                case "M":
                                    matrizM = Matriz;

                                    break;
                                case "N":
                                    matrizN = Matriz;

                                    break;
                                case "O":
                                    matrizO = Matriz;
                                    break;
                                case "P":
                                    matrizP = Matriz;

                                    break;
                                case "Q":
                                    matrizQ = Matriz;

                                    break;
                                case "R":
                                    matrizR = Matriz;

                                    break;
                                case "S":
                                    matrizS = Matriz;

                                    break;
                                case "T":
                                    matrizT = Matriz;

                                    break;
                                case "U":
                                    matrizU = Matriz;

                                    break;
                                case "V":
                                    matrizV = Matriz;

                                    break;
                                case "W":
                                    matrizW = Matriz;

                                    break;
                                case "X":
                                    matrizX = Matriz;

                                    break;
                                case "Y":
                                    matrizY = Matriz;

                                    break;
                                case "Z":
                                    matrizZ = Matriz;

                                    break;

                            }

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

    public static void submenuMultiplicacion() {
        String opcion;
        int numero;

        boolean flag = true;
        while (flag) {
            flag = false;

            System.out.print("-------------");
            System.out.print(" SUB - MENU ");
            System.out.println("-------------");
            System.out.println("  1. MULTIPLICACION MATRIZ-MATRIZ");
            System.out.println("  2. MULTIPLICACION MATRIZ-NUMERO");
            System.out.println("--------------------------");
            System.out.println("\nELEGIN UNA OPCION: \n");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1": {
                    System.out.println("Ingrese el nombre de la primera Matriz:");
                    double[][] matriz5 = EncontrarMatriz();//encuentra la matriz para poder ser utilizada y la guardamos en nueva variable
                    System.out.println("Ingrese el nombre de la segunda Matriz:");
                    double[][] matriz6 = EncontrarMatriz();
                    matrizR = multiplicarMatriz(matriz5, matriz6);
                    break;
                }
                case "2": {
                    System.out.println("Ingrese el nombre de la primera Matriz");
                    double[][] matriz7 = EncontrarMatriz();
                    System.out.println("Ingrese el numero a multiplicar");
                    numero = entrada.nextInt();
                    matrizR = multiplicarMatrizNum(matriz7, numero);
                    break;
                }
                default: {
                    System.out.println("La opcion ingresada no es valida");
                    flag = true;
                }

            }// CIERRE DEL SWITCH

        }// CIERRRE DEL WHILE
    }// CIERRRE DEL METODO SUBMENU

    public static double[][] EncontrarMatriz() {
        try {
            String Opcion = entrada.nextLine().toUpperCase();
            switch (Opcion) {
                case "A":
                    return matrizA;
                case "B":
                    return matrizB;
                case "C":
                    return matrizC;
                case "D":
                    return matrizD;
                case "E":
                    return matrizE;
                case "F":
                    return matrizF;
                case "G":
                    return matrizG;
                case "H":
                    return matrizH;
                case "I":
                    return matrizI;
                case "J":
                    return matrizJ;
                case "K":
                    return matrizK;
                case "L":
                    return matrizL;
                case "M":
                    return matrizM;
                case "N":
                    return matrizN;
                case "O":
                    return matrizO;
                case "P":
                    return matrizP;
                case "Q":
                    return matrizQ;
                case "R":
                    return matrizR;
                case "S":
                    return matrizS;
                case "T":
                    return matrizT;
                case "U":
                    return matrizU;
                case "V":
                    return matrizV;
                case "W":
                    return matrizW;
                case "X":
                    return matrizX;
                case "Y":
                    return matrizY;
                case "Z":
                    return matrizZ;

            }
        } catch (Exception e) {
            System.out.println("¡Ups! Ocurrió un error, inténtalo de nuevo.");
            entrada.nextLine();

        }
        return null;
    }

    public static double[][] multiplicarMatriz(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        // se comprueba si las matrices se pueden multiplicar
        System.out.println("Primera matriz:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("|" + a[i][j] + "|");
            }
            System.out.println("");
        }

        System.out.println("Segunda matriz:");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print("|" + b[i][j] + "|");
            }
            System.out.println("");
        }
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
        System.out.println("Matriz resultado es:");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print("|" + c[i][j] + "|");
            }
            System.out.println("");
        }
        return c;
    }

    public static double[][] multiplicarMatrizNum(double[][] a, int b) {
        double[][] resultado = new double[a.length][a[0].length];

        System.out.println("Primera matriz:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("|" + a[i][j] + "|");
            }
            System.out.println("");
        }

        System.out.println("Numero multiplicar");
        System.out.println(b);

        for (int x = 0; x < resultado.length; x++) {
            for (int y = 0; y < resultado[x].length; y++) {
                resultado[x][y] = b * a[x][y];

            }
        }
        System.out.println("Matriz resultado es:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {
                System.out.print("|" + resultado[i][j] + "|");
            }
            System.out.println("");
        }
        return resultado;
    }

    public static double[][] TranspuestaMatriz(double[][] a) {
        double[][] matrizT = new double[a[0].length][a.length];
        System.out.println("La matriz es:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("La transpuesta de esa matriz es: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                matrizT[i][j] = a[j][i];
                System.out.print(matrizT[i][j] + "   ");
            }
            System.out.println("");
        }
        return matrizT;

    }

    public static double[][] sumarMatriz(double[][] matriz1, double[][] matriz2) {

        double[][] matrizResultado;
        int filasA = matriz1.length;
        int columnasA = matriz1[0].length;

        int filasB = matriz2.length;
        int columnasB = matriz2[0].length;

        System.out.println("Primera matriz:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print("|" + matriz1[i][j] + "|");
            }
            System.out.println("");
        }

        System.out.println("Segunda matriz:");
        for (int i = 0; i < filasB; i++) {
            for (int j = 0; j < columnasB; j++) {
                System.out.print("|" + matriz2[i][j] + "|");
            }
            System.out.println("");
        }

        if (filasA == filasB && columnasB == columnasA) {

            matrizResultado = new double[filasA][columnasA];
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    matrizResultado[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }

        } else {
            throw new Error("Las matrices deben tener la misma cantidad de filas que columnas");
        }
        System.out.println("Matriz resultado es:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print("|" + matrizResultado[i][j] + "|");
            }
            System.out.println("");
        }
        return matrizResultado;
    }

    public static double[][] restarMatriz(double[][] matriz3, double[][] matriz4) {
        double[][] matrizResultado;
        int filasA = matriz3.length;
        int columnasA = matriz3[0].length;

        int filasB = matriz4.length;
        int columnasB = matriz4[0].length;
        System.out.println("Primera matriz:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print("|" + matriz3[i][j] + "|");
            }
            System.out.println("");
        }

        System.out.println("Segunda matriz:");
        for (int i = 0; i < filasB; i++) {
            for (int j = 0; j < columnasB; j++) {
                System.out.print("|" + matriz4[i][j] + "|");
            }
            System.out.println("");
        }

        if (filasA == filasB && columnasB == columnasA) {

            matrizResultado = new double[filasA][columnasA];

            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    matrizResultado[i][j] = matriz3[i][j] - matriz4[i][j];
                }
            }

        } else {
            throw new Error("Las matrices deben tener la misma cantidad de filas que columnas");
        }
        System.out.println("Matriz resultado es:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print("|" + matrizResultado[i][j] + "|");
            }
            System.out.println("");
        }
        return matrizResultado;
    }

}
