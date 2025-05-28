package org.hashing.algorithms.basic;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate {
    public static Integer findFirstDuplicate(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) return num;
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 5, 3};
        System.out.println("First duplicate: " + FirstDuplicate.findFirstDuplicate(arr)); // 5
    }
}
