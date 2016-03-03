package org.fasttrackit.util;

public class Example {
    public static void main(String[] args) {
        Calc calculatorulMeu = new Calc(4);

        int suma = calculatorulMeu.add(567, 876);
        System.out.println(suma);

        suma = calculatorulMeu.add(3, 50);
        System.out.println(suma);
    }
}

