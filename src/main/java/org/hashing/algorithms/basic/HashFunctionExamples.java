package org.hashing.algorithms.basic;

public class HashFunctionExamples {
    public static int divisionMethod(int key, int tableSize) {
        return key % tableSize;
    }

    public static int multiplicationMethod(int key, int tableSize) {
        double A = 0.6180339887; // Knuth's suggestion
        double frac = key * A - Math.floor(key * A);
        return (int)(tableSize * frac);
    }

    public static void main(String[] args) {
        int key = 12345;
        int tableSize = 100;

        System.out.println("Division Method: " + divisionMethod(key, tableSize));
        System.out.println("Multiplication Method: " + multiplicationMethod(key, tableSize));
    }
}

