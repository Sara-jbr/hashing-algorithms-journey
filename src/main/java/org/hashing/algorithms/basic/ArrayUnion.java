package org.hashing.algorithms.basic;

import java.util.HashSet;
import java.util.Set;

public class ArrayUnion {
    public static Set<Integer> union(int[] a, int[] b) {
        Set<Integer> result = new HashSet<>();
        for (int n : a) result.add(n);
        for (int n : b) result.add(n);
        return result;
    }
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {2, 3};
        System.out.println("Union: " + ArrayUnion.union(a, b)); // [1, 2, 3]
    }
}
