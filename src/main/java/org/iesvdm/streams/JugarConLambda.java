package org.iesvdm.streams;

public class JugarConLambda {

    public static double suma(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        Operacion op = (x, y) -> x + y;

        System.out.println("Suma"+op.oper(1, 2));

        op = (x, y) -> x * y;

        System.out.println("producto: " + op.oper(2, 3) );
    }
}
