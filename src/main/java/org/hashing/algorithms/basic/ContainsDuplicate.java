package org.hashing.algorithms.basic;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1};
        System.out.println("Has duplicate? " + ContainsDuplicate.hasDuplicate(arr)); // true
    }
}

