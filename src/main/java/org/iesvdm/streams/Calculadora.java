package org.iesvdm.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculadora {

    private static Map<String, Operacion> operaciones = new HashMap<>();

    private static Map<String, OperacionString> operacionesString = new HashMap<>();

    public static void main(String[] args) {
        //Operaciones Numéricas
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

        //Operaciones de String
        operacionesString.put("upper", s -> s.toUpperCase());
        operacionesString.put("lower", s -> s.toLowerCase());
        operacionesString.put("reverse", s -> new StringBuilder(s).reverse().toString());
        operacionesString.put("length", s -> String.valueOf(s.length()));
        operacionesString.put("trim", s -> s.trim());

        //Operaciones con Predicado
        Predicado esPar = x -> x % 2 == 0;
        Predicado esPrimo = x -> {
            if (x <= 1) return false;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) return false;
            }
            return true;
        };
        Predicado multiplo5 = x -> x % 5 == 0;
        Predicado entre10y100 = x -> x >= 10 && x <= 100;
        
        //Pedimos por teclado 
        Scanner scanner = new Scanner(System.in);
        String input ="";
        //se puede hacer un Boolean salir = false;
        //para dejarlo todo en una variable
        boolean salir =false;

    while (!"exit".equals(input) && !"salir".equals(input)) {

    input = scanner.nextLine();
    //Refinamiento progresivo de la idea
    //input = "+ 23 45"

    String[] instruccionArray = input.trim().split(" ");

    // if para comprobar si la operación es númerica
    if (instruccionArray.length == 3) {
        //3 elementos en la instruccion
        //["+", "23", "45"]
        if (!operaciones.containsKey(instruccionArray[0])) {
            System.out.println("Operación " + instruccionArray[0] + " no soportada");
        } else {
            Double x = null;
            Double y = null;

            try {
                x = Double.parseDouble(instruccionArray[1]);
            } catch (NumberFormatException nfe) {
                System.out.println("Formato del 1er parámetro " + instruccionArray[1] + " inválido");
            }

            try {
                y = Double.parseDouble(instruccionArray[2]);
            } catch (NumberFormatException nfe) {
                System.out.println("Formato del 2º parámetro " + instruccionArray[2] + " inválido");
            }

            if (x != null && y != null) {
                Operacion operacionFinal = operaciones.get(instruccionArray[0]);
                double resultado = operacionFinal.oper(x, y);
                System.out.println("Resultado: " + resultado);
            }
        }
    }

    // else if para ver si la operacion es de String
    else if (instruccionArray.length == 2 && operacionesString.containsKey(instruccionArray[0])) {
        //2 elementos en la instruccion y key de la operacion
        //["upper", "hola"]
        OperacionString opTxt = operacionesString.get(instruccionArray[0]);
        String resultado = opTxt.oper(instruccionArray[1]);
        System.out.println("Resultado: " + resultado);
    }

    // else if para ver si es un predicado lo introducido
    else if (instruccionArray.length == 2 && "pred".equals(instruccionArray[0])) {
        //2 elementos en la instruccion y key de la operacion
        //["pred", "23"]
        try {
            int n = Integer.parseInt(instruccionArray[1]);
            System.out.println("¿Es par? " + esPar.test(n));
            System.out.println("¿Es primo? " + esPrimo.test(n));
            System.out.println("¿Es múltiplo de 5? " + multiplo5.test(n));
            System.out.println("¿Está entre 10 y 100? " + entre10y100.test(n));
        } catch (NumberFormatException e) {
            System.out.println("Formato inválido, debe ser un número para predicados.");
        }
    }

    // else si el formato no coincide con lo introducido
    else {
        System.out.println("Formato de entrada " + input + " incorrecto");
    }
}
    }
    /* //Podriamos instanciar un metodo de parseo
    public static Double parseo (String str){
        return Double.parseDouble(str);
    } */
}
