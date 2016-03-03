package org.fasttrackit.util;

/**
 * Created by robertt on 3/3/2016.
 */
public class Calc {
    private double maxNumber;

    public Calc(int maxLength) {
        maxNumber = Math.pow(10, maxLength);
    }

    public int add(int a, int b) {
        int s = a + b;
        if (s >= maxNumber) {
            System.out.println("sum was " + s);
            s = (int) (maxNumber - 1);

        }
        return s;
    }
}
