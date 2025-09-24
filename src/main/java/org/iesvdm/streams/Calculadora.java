package org.iesvdm.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculadora {

    private static Map<String, Operacion> operaciones = new HashMap<>();

    public static void main(String[] args) {

        //Podemos agrupar los dos alias en una sola operacion
        Operacion suma = (x, y) -> x + y;
        operaciones.put("+", suma);
        operaciones.put("add", suma);
        //Podemos hacer cada alias individualmente repitiendo la lambda
        operaciones.put("-", (x, y) -> x - y);
        operaciones.put("sub", (x, y) -> x - y);

        operaciones.put("*", (x, y) -> x * y);
        operaciones.put("mul", (x, y) -> x * y);

        operaciones.put("/", (x, y) -> x / y);
        operaciones.put("div", (x, y) -> x / y); 
        
        Scanner scanner = new Scanner(System.in);
        String input ="";
        //se puede hacer un Boolean salir = false;
        //para dejarlo todo en una variable
        boolean salir =false;

        while (!"exit".equals(input) || !"salir".equals(input)){
            input = scanner.nextLine();
            //Refinamiento progresivo de la idea
            //input = "+ 23 45"


            String[] instruccionArray = input.trim().split(" ");

            if (instruccionArray.length != 3) {
                System.out.println("Formato de entrada " + input + " incorrecto");
            } else{
                //3 elementos en la instruccion
                //["+", "23", "45"]
                if(!operaciones.containsKey(instruccionArray[0])){
                    System.out.println("Operacion " + instruccionArray[0] + " no soportada");
                } else {
                    Double x = null;
                    try {
                        x = Double.parseDouble(instruccionArray[1]);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato del 1er parámetro " + instruccionArray[1] + " invalido");
                    }
                    Double y = null;
                    try {
                        y = Double.parseDouble(instruccionArray[2]);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato del 2o parámetro " + instruccionArray[2] + " invalido");
                    }
                    if(x!=null && y!=null){
                        Operacion operacionFinal = operaciones.get(instruccionArray[0]);
                        double resultado = operacionFinal.oper(x, y);
                        System.out.println("Resultado: " + resultado);
                    }
                }
            }
        }
    }
    /* //Podriamos instanciar un metodo de parseo
    public static Double parseo (String str){
        return Double.parseDouble(str);
    } */
}
