package org.hashing.algorithms.basic;

import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
    public static Set<Integer> intersection(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int n : a) setA.add(n);
        for (int n : b) if (setA.contains(n)) result.add(n);
        return result;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 3, 4};
        System.out.println("Intersection: " + ArrayIntersection.intersection(a, b)); // [2, 3]
    }
}
